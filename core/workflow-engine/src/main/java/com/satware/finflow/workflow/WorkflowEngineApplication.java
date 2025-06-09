package com.satware.finflow.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.statemachine.config.EnableStateMachine;

/**
 * FinFlow Workflow Engine Application
 * 
 * Core orchestration engine for financial workflow automation.
 * Implements event-driven workflow processing with built-in
 * compliance and audit capabilities.
 * 
 * @author satware AG - FinFlow Team
 * @version 1.0.0
 */
@SpringBootApplication
@EnableKafka
@EnableStateMachine
public class WorkflowEngineApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(WorkflowEngineApplication.class, args);
    }
}