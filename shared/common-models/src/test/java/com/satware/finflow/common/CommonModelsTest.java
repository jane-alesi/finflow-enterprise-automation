package com.satware.finflow.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.satware.finflow.common.model.Transaction;
import com.satware.finflow.common.model.AuditEvent;
import com.satware.finflow.common.util.FinFlowUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Unit tests for common models and utilities.
 */
class CommonModelsTest {

    @Test
    void transactionModelTest() {
        Transaction transaction = new Transaction(
            "TXN123", "ACC001", "ACC002", new BigDecimal("100.50"), "USD", 
            "Test transaction", LocalDateTime.now(), "COMPLETED"
        );
        
        assertNotNull(transaction);
        assertEquals("TXN123", transaction.getTransactionId());
        assertEquals(new BigDecimal("100.50"), transaction.getAmount());
    }

    @Test
    void auditEventModelTest() {
        AuditEvent auditEvent = new AuditEvent(
            "AUDIT001", "LOGIN", "USER001", "WORKFLOW001", LocalDateTime.now(), "User logged in"
        );
        
        assertNotNull(auditEvent);
        assertEquals("LOGIN", auditEvent.getEventType());
        assertEquals("USER001", auditEvent.getUserId());
    }

    @Test
    void finFlowUtilsGenerateUniqueIdTest() {
        String id1 = FinFlowUtils.generateUniqueId();
        String id2 = FinFlowUtils.generateUniqueId();
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotEquals(id1, id2);
    }

    @Test
    void finFlowUtilsIsBlankTest() {
        assertTrue(FinFlowUtils.isBlank(null));
        assertTrue(FinFlowUtils.isBlank(""));
        assertTrue(FinFlowUtils.isBlank("   "));
        assertFalse(FinFlowUtils.isBlank("text"));
    }

    @Test
    void finFlowUtilsFormatCurrencyTest() {
        assertEquals("$100.50", FinFlowUtils.formatCurrency(new BigDecimal("100.50"), "USD"));
        assertEquals("€1,234.56", FinFlowUtils.formatCurrency(new BigDecimal("1234.56"), "EUR"));
        assertEquals("", FinFlowUtils.formatCurrency(null, "USD"));
        assertEquals("", FinFlowUtils.formatCurrency(new BigDecimal("100"), null));
    }
}
