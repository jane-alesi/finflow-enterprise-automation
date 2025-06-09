package com.satware.finflow.shared.model;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Shared Transaction Model
 * 
 * Represents a financial transaction, used across multiple FinFlow modules.
 * 
 * @author satware AG - FinFlow Team
 */
@Data
public class Transaction {
    @NotBlank
    private String transactionId;
    @NotBlank
    private String fromAccount;
    @NotBlank
    private String toAccount;
    @NotNull
    @Positive
    private BigDecimal amount;
    @NotBlank
    private String currency;
    private String description;
    private LocalDateTime timestamp;
    private String status;
    private String workflowId;
    private String auditTrailId;
}