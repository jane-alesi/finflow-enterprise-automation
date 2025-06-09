package com.satware.finflow.common.model;

/**
 * Workflow Status Enumeration
 * 
 * Defines the possible states of a workflow definition
 * throughout its lifecycle.
 * 
 * @author satware AG - FinFlow Team
 */
public enum WorkflowStatus {
    
    /**
     * Workflow is being created or modified
     */
    DRAFT,
    
    /**
     * Workflow is under review for approval
     */
    PENDING_APPROVAL,
    
    /**
     * Workflow has been approved and is active
     */
    ACTIVE,
    
    /**
     * Workflow is temporarily suspended
     */
    SUSPENDED,
    
    /**
     * Workflow has been deprecated but may still be referenced
     */
    DEPRECATED,
    
    /**
     * Workflow has been archived and is no longer available
     */
    ARCHIVED;
    
    /**
     * Check if the workflow status allows execution
     * 
     * @return true if workflow can be executed
     */
    public boolean isExecutable() {
        return this == ACTIVE;
    }
    
    /**
     * Check if the workflow status allows modification
     * 
     * @return true if workflow can be modified
     */
    public boolean isModifiable() {
        return this == DRAFT || this == SUSPENDED;
    }
    
    /**
     * Get the next possible statuses from current status
     * 
     * @return array of possible next statuses
     */
    public WorkflowStatus[] getNextPossibleStatuses() {
        return switch (this) {
            case DRAFT -> new WorkflowStatus[]{PENDING_APPROVAL, ARCHIVED};
            case PENDING_APPROVAL -> new WorkflowStatus[]{ACTIVE, DRAFT, ARCHIVED};
            case ACTIVE -> new WorkflowStatus[]{SUSPENDED, DEPRECATED};
            case SUSPENDED -> new WorkflowStatus[]{ACTIVE, DEPRECATED};
            case DEPRECATED -> new WorkflowStatus[]{ARCHIVED};
            case ARCHIVED -> new WorkflowStatus[]{}; // No transitions from archived
        };
    }
}