package com.satware.finflow.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a generic financial transaction.
 * This model is shared across various FinFlow modules.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    
    @NotBlank(message = "Transaction ID cannot be blank")
    private String transactionId;
    
    @NotBlank(message = "From account cannot be blank")
    private String fromAccount;
    
    @NotBlank(message = "To account cannot be blank")
    private String toAccount;
    
    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    private BigDecimal amount;
    
    @NotBlank(message = "Currency cannot be blank")
    private String currency;
    
    private String description;
    
    @NotNull(message = "Timestamp cannot be null")
    private LocalDateTime timestamp;
    
    private String status;
}
