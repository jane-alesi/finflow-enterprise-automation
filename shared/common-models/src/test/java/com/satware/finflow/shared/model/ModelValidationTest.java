package com.satware.finflow.shared.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for shared data models validation.
 * 
 * Verifies that the validation constraints defined in the shared models
 * are correctly applied.
 * 
 * @author satware AG - FinFlow Team
 */
class ModelValidationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void transaction_valid() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId("TXN123");
        transaction.setFromAccount("ACC001");
        transaction.setToAccount("ACC002");
        transaction.setAmount(new BigDecimal("100.00"));
        transaction.setCurrency("EUR");
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus("PENDING");

        Set<jakarta.validation.ConstraintViolation<Transaction>> violations = validator.validate(transaction);
        assertTrue(violations.isEmpty());
    }

    @Test
    void transaction_invalid_amount() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId("TXN123");
        transaction.setFromAccount("ACC001");
        transaction.setToAccount("ACC002");
        transaction.setAmount(new BigDecimal("-10.00")); // Invalid amount
        transaction.setCurrency("EUR");
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus("PENDING");

        Set<jakarta.validation.ConstraintViolation<Transaction>> violations = validator.validate(transaction);
        assertEquals(1, violations.size());
        assertEquals("must be greater than 0", violations.iterator().next().getMessage());
    }

    @Test
    void auditEntry_valid() {
        AuditEntry auditEntry = new AuditEntry();
        auditEntry.setEntryId("AUDIT001");
        auditEntry.setEventType("LOGIN");
        auditEntry.setTimestamp(LocalDateTime.now());
        auditEntry.setUserId("user123");

        Set<jakarta.validation.ConstraintViolation<AuditEntry>> violations = validator.validate(auditEntry);
        assertTrue(violations.isEmpty());
    }

    @Test
    void complianceResult_valid() {
        ComplianceResult complianceResult = new ComplianceResult();
        complianceResult.setWorkflowId("WF001");
        complianceResult.setCompliant(true);
        complianceResult.setViolations(Collections.emptyList());
        complianceResult.setWarnings(Collections.emptyList());
        complianceResult.setValidationTimestamp(LocalDateTime.now());

        Set<jakarta.validation.ConstraintViolation<ComplianceResult>> violations = validator.validate(complianceResult);
        assertTrue(violations.isEmpty());
    }
}