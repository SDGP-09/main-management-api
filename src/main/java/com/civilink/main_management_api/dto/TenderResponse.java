package com.civilink.main_management_api.dto;


import com.civilink.main_management_api.entity.Task;
import com.civilink.main_management_api.entity.Tender;

public class TenderResponse {

    private String id;
    private String name;
    private String openDate;
    private String closeDate;
    private String progress;
    private String dependencies;



    public TenderResponse(Task newTask) {
    }


    public TenderResponse(Tender tender) {
        this.id = tender.getId();
        this.name = tender.getName();
        this.openDate = tender.getOpenDate();
        this.closeDate = tender.getCloseDate();
        this.progress = tender.getProgress();
        this.dependencies = tender.getDependencies();

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

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String startDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
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



}
