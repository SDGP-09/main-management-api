package com.civilink.main_management_api.controller;

import com.civilink.main_management_api.dto.TaskRequest;
import com.civilink.main_management_api.util.Projects;
import com.civilink.main_management_api.util.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/project")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    Projects projects;

    @PostMapping("/add-task")
    public void addTask(@RequestBody TaskRequest taskRequest) {

        Task newTask = new Task(
                taskRequest.getId(),
                taskRequest.getName(),
                taskRequest.getStartDate(),
                taskRequest.getEndDate(),
                taskRequest.getProgress(),
                taskRequest.getDependencies(),
                taskRequest.getDescription()
        );
        projects.addProject(newTask);
        System.out.println(projects.getProjects().toString());

    }

    @GetMapping
    public List<Task> getTasks() {
        return projects.getProjects();
    }



    @PutMapping("/update-task/{id}")
    public void updateTask(@PathVariable String id, @RequestBody TaskRequest taskRequest) {
        
        Task updatedTask = new Task(
                id,
                taskRequest.getName(),
                taskRequest.getStartDate(),
                taskRequest.getEndDate(),
                taskRequest.getProgress(),
                taskRequest.getDependencies(),
                taskRequest.getDescription()
        );
        projects.deleteProject(id);
        projects.addProject(updatedTask);
        

    }



    @DeleteMapping("/delete-task/{id}")
    public void deleteTask(@PathVariable String id) {
        projects.deleteProject(id);


    }
}




