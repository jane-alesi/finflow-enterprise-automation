package com.satware.finflow.common.model;

/**
 * Workflow Step Type Enumeration
 * 
 * Defines the different types of steps that can be
 * included in a financial workflow.
 * 
 * @author satware AG - FinFlow Team
 */
public enum StepType {
    
    /**
     * Data validation step
     */
    VALIDATION,
    
    /**
     * Data transformation step
     */
    TRANSFORMATION,
    
    /**
     * Compliance check step
     */
    COMPLIANCE_CHECK,
    
    /**
     * External service call
     */
    SERVICE_CALL,
    
    /**
     * Database operation
     */
    DATABASE_OPERATION,
    
    /**
     * File processing step
     */
    FILE_PROCESSING,
    
    /**
     * Notification step
     */
    NOTIFICATION,
    
    /**
     * Approval step requiring human intervention
     */
    APPROVAL,
    
    /**
     * Decision point with conditional logic
     */
    DECISION,
    
    /**
     * Audit trail generation
     */
    AUDIT,
    
    /**
     * Custom script execution
     */
    CUSTOM_SCRIPT;
    
    /**
     * Check if the step type requires human intervention
     * 
     * @return true if human intervention is required
     */
    public boolean requiresHumanIntervention() {
        return this == APPROVAL;
    }
    
    /**
     * Check if the step type is automated
     * 
     * @return true if step can be executed automatically
     */
    public boolean isAutomated() {
        return !requiresHumanIntervention();
    }
    
    /**
     * Get the category of the step type
     * 
     * @return step category
     */
    public StepCategory getCategory() {
        return switch (this) {
            case VALIDATION, TRANSFORMATION -> StepCategory.DATA_PROCESSING;
            case COMPLIANCE_CHECK, AUDIT -> StepCategory.COMPLIANCE;
            case SERVICE_CALL, DATABASE_OPERATION, FILE_PROCESSING -> StepCategory.INTEGRATION;
            case NOTIFICATION, APPROVAL -> StepCategory.HUMAN_INTERACTION;
            case DECISION, CUSTOM_SCRIPT -> StepCategory.LOGIC;
        };
    }
    
    /**
     * Step categories for grouping related step types
     */
    public enum StepCategory {
        DATA_PROCESSING,
        COMPLIANCE,
        INTEGRATION,
        HUMAN_INTERACTION,
        LOGIC
    }
}