package com.civilink.main_management_api.dto;
import com.civilink.main_management_api.entity.Task;

public class TaskResponse {
    private String id;
    private String name;
    private String startDate;
    private String endDate;
    private String progress;
    private String dependencies;
    private String description;

    // Default constructor
    public TaskResponse() {
    }

    // Constructor to create from Task entity
    public TaskResponse(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.startDate = task.getStartDate();
        this.endDate = task.getEndDate();
        this.progress = task.getProgress();
        this.dependencies = task.getDependencies();
        this.description = task.getDescription();
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getDependencies() {
        return dependencies;
    }

    public void setDependencies(String dependencies) {
        this.dependencies = dependencies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
