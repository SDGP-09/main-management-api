package com.civilink.main_management_api.util;

public class Task {
    private String id;
    private String name;
    private String startDate;
    private String endDate;
    private String progress;
    private String dependencies;
    private String description;

    public Task(String id, String name, String startDate, String endDate, String progress, String dependencies, String description) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.progress = progress;
        this.dependencies = dependencies;
        this.description = description;
    }

    // ✅ Add Getters (Required for JSON serialization)
    public String getId() { return id; }
    public String getName() { return name; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public String getProgress() { return progress; }
    public String getDependencies() { return dependencies; }
    public String getDescription() { return description; }
}