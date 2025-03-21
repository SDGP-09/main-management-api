package com.civilink.main_management_api.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Projects {

    List<Task>projects=new ArrayList<>();

    public void addProject(Task task){
        projects.add(task);
    }

    public void deleteProject(String id){
        projects.removeIf(task -> task.getId().equals(id));
    }

    public List<Task> getProjects() {
        return projects;
    }

    public void setProjects(List<Task> projects) {
        this.projects = projects;
    }

    public Projects() {
    }

    public Projects(List<Task> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "projects=" + projects +
                '}';
    }
}
