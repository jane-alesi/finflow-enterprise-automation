package com.satware.finflow.legacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * FinFlow Legacy Adapter Application
 * 
 * Provides integration capabilities with various legacy financial systems
 * through a set of configurable adapters.
 * 
 * @author satware AG - FinFlow Team
 * @version 1.0.0
 */
@SpringBootApplication
public class LegacyAdapterApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(LegacyAdapterApplication.class, args);
    }
}