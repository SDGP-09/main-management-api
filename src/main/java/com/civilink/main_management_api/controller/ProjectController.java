package com.civilink.main_management_api.controller;

import com.civilink.main_management_api.dto.TaskRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
@CrossOrigin("*")
public class ProjectController {

    @PostMapping("/add-task")
    public void addTask(@RequestBody TaskRequest taskRequest) {

        System.out.println("Adding task: " + taskRequest.getName()+": "+taskRequest.getDescription()+""+taskRequest.getStartDate()+"" +taskRequest.getEndDate()+""+taskRequest.getProgress()+""+taskRequest.getDependencies());
    }
}
