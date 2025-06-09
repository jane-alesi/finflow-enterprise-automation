package com.satware.finflow.compliance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * Integration test for Compliance Engine Application
 * 
 * Verifies that the Spring Boot application context loads correctly
 * with all required compliance and audit components.
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
class ComplianceEngineApplicationTest {
    
    @Test
    void contextLoads() {
        // This test verifies that the Spring Boot application context
        // loads successfully with all required configurations
    }
}