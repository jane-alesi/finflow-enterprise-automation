package com.satware.finflow.adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * FinFlow Legacy Adapter Application
 * 
 * Connects FinFlow to various legacy financial systems,
 * handling data transformation and protocol translation.
 * 
 * @author satware AG - FinFlow Team
 * @version 1.0.0
 */
@SpringBootApplication
@EnableKafka
public class LegacyAdapterApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(LegacyAdapterApplication.class, args);
    }
}