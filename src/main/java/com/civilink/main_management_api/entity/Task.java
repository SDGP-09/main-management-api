package com.civilink.main_management_api.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String startDate;
    private String endDate;
    private String progress;
    private String dependencies;
    private String description;

    public Task() {
        // Set default dates
        LocalDate today = LocalDate.now();
        this.startDate = today.toString();
        this.endDate = today.plusDays(1).toString();
        this.progress = "0";
    }

    public Task(String id, String name, String startDate, String endDate, String progress, String dependencies, String description) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.progress = progress;
        this.dependencies = dependencies;
        this.description = description;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

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
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", progress='" + progress + '\'' +
                ", dependencies='" + dependencies + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
