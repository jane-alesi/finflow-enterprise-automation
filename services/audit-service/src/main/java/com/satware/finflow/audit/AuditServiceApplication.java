package com.satware.finflow.audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * FinFlow Audit Service Application
 * 
 * Microservice responsible for comprehensive audit trail management,
 * regulatory reporting, and compliance documentation for all
 * financial workflow activities.
 * 
 * @author satware AG - FinFlow Team
 * @version 1.0.0
 */
@SpringBootApplication
@EnableKafka
public class AuditServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AuditServiceApplication.class, args);
    }
}