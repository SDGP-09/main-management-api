package com.civilink.main_management_api.controller;

import com.civilink.main_management_api.dto.TaskRequest;
import com.civilink.main_management_api.util.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/project")
@CrossOrigin ("*")
public class ProjectController {

    @PostMapping("/add-task")
    public void addTask(@RequestBody TaskRequest taskRequest) {

        System.out.println("Adding task: " + taskRequest.getName()+": "+taskRequest.getDescription()+""+taskRequest.getStartDate()+"" +taskRequest.getEndDate()+""+taskRequest.getProgress()+""+taskRequest.getDependencies());
    }

    @GetMapping
    public List<Task> getTasks(){
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("1234" , "amal","2025-03-20","2025-03-25", "20","","xxxxxxxxx"));
        tasks.add(new Task("1211" , "aaaa","2025-03-20","2025-03-26", "20","1234","xxxyyyyyx"));
        return tasks;
    }
}
