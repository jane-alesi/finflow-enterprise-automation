package com.satware.finflow.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * Represents a generic audit event.
 * This model is shared across various FinFlow modules.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditEvent {
    
    @NotBlank(message = "Event ID cannot be blank")
    private String eventId;
    
    @NotBlank(message = "Event type cannot be blank")
    private String eventType;
    
    @NotBlank(message = "User ID cannot be blank")
    private String userId;
    
    private String workflowId;
    
    @NotNull(message = "Timestamp cannot be null")
    private LocalDateTime timestamp;
    
    private String eventData;
}
