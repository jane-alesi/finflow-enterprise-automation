package com.satware.finflow.workflow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * Integration test for Workflow Engine Application
 * 
 * Verifies that the Spring Boot application context loads correctly
 * with all required beans and configurations.
 * 
 * @author satware AG - FinFlow Team
 */
@SpringBootTest
@TestPropertySource(properties = {
    "spring.kafka.consumer.auto-offset-reset=earliest",
    "spring.kafka.consumer.group-id=test-group",
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.jpa.hibernate.ddl-auto=create-drop"
})
class WorkflowEngineApplicationTest {
    
    @Test
    void contextLoads() {
        // This test verifies that the Spring Boot application context
        // loads successfully with all required configurations
    }
}