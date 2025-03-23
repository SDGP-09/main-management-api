package com.civilink.main_management_api.dto;


public class TenderRequest {
    private String id;
    private String name;
    private String openDate;
    private String closeDate;
    private String progress;
    private String dependencies;
    private String description;


    // Getters and setters
    public String getId(){ return id; }
    public void setId(String id){ this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOpenDate() { return openDate; }
    public void setOpenDate(String openDate) { this.openDate = openDate; }

    public String getCloseDate() { return closeDate; }
    public void setCloseDate(String closeDate) { this.closeDate = closeDate; }

    public String getProgress() { return progress; }
    public void setProgress(String progress) { this.progress = progress; }

    public String getDependencies() { return dependencies; }
    public void setDependencies(String dependencies) { this.dependencies = dependencies; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}

