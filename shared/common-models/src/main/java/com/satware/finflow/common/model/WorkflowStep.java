package com.satware.finflow.common.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

import java.util.Map;

/**
 * Workflow Step Model
 * 
 * Represents an individual step within a workflow definition
 * with execution parameters and conditions.
 * 
 * @author satware AG - FinFlow Team
 */
public class WorkflowStep {
    
    @NotBlank
    private String id;
    
    @NotBlank
    private String name;
    
    private String description;
    
    @NotNull
    private StepType type;
    
    @Min(0)
    private int order;
    
    private Map<String, Object> configuration;
    
    private String condition;
    
    private String nextStepId;
    
    private String errorStepId;
    
    private boolean mandatory;
    
    private int timeoutSeconds;
    
    // Constructors
    public WorkflowStep() {}
    
    public WorkflowStep(String id, String name, StepType type, int order) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.order = order;
        this.mandatory = true;
        this.timeoutSeconds = 300; // 5 minutes default
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public StepType getType() { return type; }
    public void setType(StepType type) { this.type = type; }
    
    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order; }
    
    public Map<String, Object> getConfiguration() { return configuration; }
    public void setConfiguration(Map<String, Object> configuration) { this.configuration = configuration; }
    
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
    
    public String getNextStepId() { return nextStepId; }
    public void setNextStepId(String nextStepId) { this.nextStepId = nextStepId; }
    
    public String getErrorStepId() { return errorStepId; }
    public void setErrorStepId(String errorStepId) { this.errorStepId = errorStepId; }
    
    public boolean isMandatory() { return mandatory; }
    public void setMandatory(boolean mandatory) { this.mandatory = mandatory; }
    
    public int getTimeoutSeconds() { return timeoutSeconds; }
    public void setTimeoutSeconds(int timeoutSeconds) { this.timeoutSeconds = timeoutSeconds; }
    
    @Override
    public String toString() {
        return "WorkflowStep{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", order=" + order +
                '}';
    }
}