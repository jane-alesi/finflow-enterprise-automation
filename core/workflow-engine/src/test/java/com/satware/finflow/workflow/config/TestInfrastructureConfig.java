package com.satware.finflow.workflow.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

/**
 * Test Infrastructure Configuration for FinFlow Workflow Engine
 * 
 * This configuration class sets up embedded services for testing:
 * - Embedded Redis server for caching tests
 * - Custom connection factories for test isolation
 * 
 * Used in conjunction with @EmbeddedKafka for Kafka testing
 * and H2 database for JPA testing.
 */
@TestConfiguration
@Profile("test")
public class TestInfrastructureConfig {

    private RedisServer redisServer;
    private static final int REDIS_TEST_PORT = 6370;

    /**
     * Start embedded Redis server for tests
     */
    @PostConstruct
    public void startRedis() throws IOException {
        try {
            redisServer = RedisServer.builder()
                    .port(REDIS_TEST_PORT)
                    .setting("maxmemory 128M")
                    .build();
            redisServer.start();
        } catch (Exception e) {
            // Log warning but don't fail tests if Redis can't start
            System.err.println("Warning: Could not start embedded Redis server: " + e.getMessage());
            System.err.println("Redis-dependent tests may fail. Consider checking port availability.");
        }
    }

    /**
     * Stop embedded Redis server after tests
     */
    @PreDestroy
    public void stopRedis() {
        if (redisServer != null && redisServer.isActive()) {
            try {
                redisServer.stop();
            } catch (Exception e) {
                System.err.println("Warning: Could not stop embedded Redis server: " + e.getMessage());
            }
        }
    }

    /**
     * Configure Redis connection factory for tests
     * Uses the embedded Redis server on test port
     */
    @Bean
    @Primary
    @Profile("test")
    public RedisConnectionFactory redisConnectionFactory() {
        LettuceConnectionFactory factory = new LettuceConnectionFactory("localhost", REDIS_TEST_PORT);
        factory.setValidateConnection(false);
        factory.afterPropertiesSet();
        return factory;
    }
}