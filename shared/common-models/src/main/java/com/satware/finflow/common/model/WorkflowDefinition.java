package com.satware.finflow.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Workflow Definition Model
 * 
 * Represents a financial workflow definition with steps,
 * compliance rules, and execution parameters.
 * 
 * @author satware AG - FinFlow Team
 */
public class WorkflowDefinition {
    
    @NotBlank
    private String id;
    
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;
    
    @Size(max = 500)
    private String description;
    
    @NotBlank
    private String version;
    
    @NotNull
    private WorkflowStatus status;
    
    @NotNull
    private List<WorkflowStep> steps;
    
    private List<String> complianceRules;
    
    private Map<String, Object> parameters;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
    
    private String createdBy;
    
    // Constructors
    public WorkflowDefinition() {}
    
    public WorkflowDefinition(String id, String name, String version) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.status = WorkflowStatus.DRAFT;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    
    public WorkflowStatus getStatus() { return status; }
    public void setStatus(WorkflowStatus status) { this.status = status; }
    
    public List<WorkflowStep> getSteps() { return steps; }
    public void setSteps(List<WorkflowStep> steps) { this.steps = steps; }
    
    public List<String> getComplianceRules() { return complianceRules; }
    public void setComplianceRules(List<String> complianceRules) { this.complianceRules = complianceRules; }
    
    public Map<String, Object> getParameters() { return parameters; }
    public void setParameters(Map<String, Object> parameters) { this.parameters = parameters; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    
    @Override
    public String toString() {
        return "WorkflowDefinition{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", status=" + status +
                '}';
    }
}