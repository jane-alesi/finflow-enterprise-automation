package com.satware.finflow.workflow;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

/**
 * Base class for integration tests using TestContainers
 * 
 * This class provides:
 * - PostgreSQL database container for data persistence tests
 * - Kafka container for event streaming tests
 * - Redis container for caching tests
 * - Dynamic property configuration for Spring Boot
 * 
 * Uses singleton container pattern for performance optimization.
 * All integration tests should extend this class.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration-test")
@Testcontainers
public abstract class IntegrationTestBase {

    // PostgreSQL Container - Singleton pattern for performance
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("finflow_test")
            .withUsername("test")
            .withPassword("test")
            .withReuse(true);

    // Kafka Container - Singleton pattern for performance
    @Container
    static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.5.0"))
            .withReuse(true);

    // Redis Container - Singleton pattern for performance
    @Container
    static GenericContainer<?> redis = new GenericContainer<>("redis:7-alpine")
            .withExposedPorts(6379)
            .withReuse(true);

    /**
     * Configure Spring Boot properties dynamically based on container endpoints
     */
    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        // PostgreSQL Configuration
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.datasource.driver-class-name", () -> "org.postgresql.Driver");

        // Kafka Configuration
        registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);

        // Redis Configuration
        registry.add("spring.redis.host", redis::getHost);
        registry.add("spring.redis.port", () -> redis.getMappedPort(6379).toString());

        // Additional test-specific properties
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
        registry.add("spring.jpa.show-sql", () -> "true");
    }

    /**
     * Ensure all containers are started before any tests run
     */
    @BeforeAll
    static void beforeAll() {
        // Containers are automatically started by @Testcontainers annotation
        // This method can be used for additional setup if needed
        
        // Verify containers are running
        if (!postgres.isRunning()) {
            throw new RuntimeException("PostgreSQL container failed to start");
        }
        if (!kafka.isRunning()) {
            throw new RuntimeException("Kafka container failed to start");
        }
        if (!redis.isRunning()) {
            throw new RuntimeException("Redis container failed to start");
        }

        System.out.println("=== Integration Test Containers Started ===");
        System.out.println("PostgreSQL: " + postgres.getJdbcUrl());
        System.out.println("Kafka: " + kafka.getBootstrapServers());
        System.out.println("Redis: " + redis.getHost() + ":" + redis.getMappedPort(6379));
        System.out.println("==========================================");
    }
}