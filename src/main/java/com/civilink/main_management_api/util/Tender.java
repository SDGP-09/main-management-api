package com.civilink.main_management_api.util;

public class Tender {
    private String id;
    private String name;
    private String openDate;
    private String closeDate;
    private String progress;
    private String dependencies;


    public Tender(String id, String name, String openDate, String closeDate, String progress, String dependencies) {
        this.id = id;
        this.name = name;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.progress = progress;
        this.dependencies = dependencies;

    }

    public String getId() {return id;}

    public String getName() {return name;}

    public String getOpenDate() {return openDate;}

    public String getCloseDate() {return closeDate;}

    public String getProgress() {return progress;}

    public String getDependencies() {return dependencies;}


}