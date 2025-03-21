package com.civilink.main_management_api.dto;


public class TenderRequest {
    private String id;
    private String name;
    private String openDate;
    private String closeDate;
    private String progress;
    private String dependencies;


    // Getters and setters
    public String getId(){ return id; }
    public void setId(String id){ this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOpenDate() { return openDate; }
    public void setOpenDate(String startDate) { this.openDate = startDate; }

    public String getCloseDate() { return closeDate; }
    public void setCloseDate(String endDate) { this.closeDate = endDate; }

    public String getProgress() { return progress; }
    public void setProgress(String progress) { this.progress = progress; }

    public String getDependencies() { return dependencies; }
    public void setDependencies(String dependencies) { this.dependencies = dependencies; }

}

