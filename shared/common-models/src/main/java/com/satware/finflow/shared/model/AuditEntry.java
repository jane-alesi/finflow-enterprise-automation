package com.satware.finflow.shared.model;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * Shared Audit Entry Model
 * 
 * Represents an audit trail entry, used across multiple FinFlow modules.
 * 
 * @author satware AG - FinFlow Team
 */
@Data
public class AuditEntry {
    @NotBlank
    private String entryId;
    @NotBlank
    private String eventType;
    @NotNull
    private LocalDateTime timestamp;
    @NotBlank
    private String userId;
    private String workflowId;
    private String eventData;
    private String integrityHash;
}