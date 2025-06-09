package com.satware.finflow.shared.util;

/**
 * FinFlow Constants
 * 
 * Centralized constants for common values and configurations across FinFlow modules.
 * 
 * @author satware AG - FinFlow Team
 */
public final class FinFlowConstants {

    private FinFlowConstants() {
        // Private constructor to prevent instantiation
    }

    // Kafka Topics
    public static final String TOPIC_WORKFLOW_EVENTS = "finflow.workflow.events";
    public static final String TOPIC_AUDIT_EVENTS = "finflow.audit.events";
    public static final String TOPIC_COMPLIANCE_EVENTS = "finflow.compliance.events";
    public static final String TOPIC_TRANSACTION_EVENTS = "finflow.transaction.events";
    public static final String TOPIC_VIOLATION_ALERTS = "finflow.compliance.violations";

    // Workflow Statuses
    public static final String WORKFLOW_STATUS_PENDING = "PENDING";
    public static final String WORKFLOW_STATUS_COMPLETED = "COMPLETED";
    public static final String WORKFLOW_STATUS_FAILED = "FAILED";
    public static final String WORKFLOW_STATUS_CANCELLED = "CANCELLED";

    // Compliance Regulations
    public static final String REGULATION_MIFID_II = "MiFID II";
    public static final String REGULATION_PSD3 = "PSD3";
    public static final String REGULATION_GDPR = "GDPR";
    public static final String REGULATION_ESG = "ESG";

    // Audit Event Types
    public static final String AUDIT_EVENT_WORKFLOW_START = "WORKFLOW_START";
    public static final String AUDIT_EVENT_WORKFLOW_END = "WORKFLOW_END";
    public static final String AUDIT_EVENT_TRANSACTION_CREATE = "TRANSACTION_CREATE";
    public static final String AUDIT_EVENT_COMPLIANCE_VIOLATION = "COMPLIANCE_VIOLATION";

    // Default Values
    public static final String DEFAULT_CURRENCY = "EUR";
    public static final int DEFAULT_TIMEOUT_SECONDS = 30;
}