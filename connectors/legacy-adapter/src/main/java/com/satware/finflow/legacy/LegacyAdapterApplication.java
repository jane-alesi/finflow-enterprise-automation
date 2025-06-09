package com.satware.finflow.legacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.integration.config.EnableIntegration;

/**
 * FinFlow Legacy System Adapter Application
 * 
 * Integration adapter that provides connectivity to legacy financial
 * systems, enterprise applications, and external data sources using
 * enterprise integration patterns and message transformation.
 * 
 * @author satware AG - FinFlow Team
 * @version 1.0.0
 */
@SpringBootApplication
@EnableKafka
@EnableIntegration
public class LegacyAdapterApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(LegacyAdapterApplication.class, args);
    }
}