package com.civilink.main_management_api.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tenders")
public class Tender {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String openDate;
    private String closeDate;
    private String progress;
    private String dependencies;
    private String description;



    public Tender() {
        // Set default dates
        LocalDate today = LocalDate.now();
        this.openDate = today.toString();
        this.closeDate = today.plusDays(1).toString();
        this.progress = "0";
    }

    public Tender(String id, String name, String openDate, String closeDate, String progress, String dependencies, String description) {
        this.id = id;
        this.name = name;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.progress = progress;
        this.dependencies = dependencies;
        this.description = description;

    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

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


    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", startDate='" + openDate + '\'' +
                ", endDate='" + closeDate + '\'' +
                ", progress='" + progress + '\'' +
                ", dependencies='" + dependencies + '\'' +
                ", description='" + description + '\'' +

                '}';
    }

}
