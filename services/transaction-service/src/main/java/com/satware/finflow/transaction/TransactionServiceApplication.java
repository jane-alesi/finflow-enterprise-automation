package com.satware.finflow.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.cache.annotation.EnableCaching;

/**
 * FinFlow Transaction Service Application
 * 
 * Microservice responsible for financial transaction processing,
 * validation, and management with real-time event streaming
 * and comprehensive audit capabilities.
 * 
 * @author satware AG - FinFlow Team
 * @version 1.0.0
 */
@SpringBootApplication
@EnableKafka
@EnableCaching
public class TransactionServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }
}