package com.satware.finflow.compliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * FinFlow Compliance Engine Application
 * 
 * Regulatory compliance validation engine that ensures all financial
 * workflows meet EU regulatory standards including MiFID II, PSD3,
 * GDPR, and ESG requirements.
 * 
 * @author satware AG - FinFlow Team
 * @version 1.0.0
 */
@SpringBootApplication
@EnableKafka
public class ComplianceEngineApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ComplianceEngineApplication.class, args);
    }
}