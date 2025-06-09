package com.satware.finflow.shared.model;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Shared Compliance Result Model
 * 
 * Represents the outcome of a compliance validation, used across multiple FinFlow modules.
 * 
 * @author satware AG - FinFlow Team
 */
@Data
public class ComplianceResult {
    @NotBlank
    private String workflowId;
    private boolean compliant;
    private List<String> violations;
    private List<String> warnings;
    @NotNull
    private LocalDateTime validationTimestamp;
}