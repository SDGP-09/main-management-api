package com.civilink.main_management_api.controller;


import com.civilink.main_management_api.dto.TaskRequest;
import com.civilink.main_management_api.dto.TaskResponse;
import com.civilink.main_management_api.entity.Task;
import com.civilink.main_management_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")
public class TaskController {
    @Autowired
    private TaskService taskService;

    // Create empty task (for new task form)
    @PostMapping("/create-empty")
    public ResponseEntity<TaskResponse> createEmptyTask() {
        Task newTask = taskService.createEmptyTask();
        return ResponseEntity.ok(new TaskResponse(newTask));
    }

    // Get all tasks for Gantt chart
    @GetMapping("/all")
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        List<TaskResponse> responses = tasks.stream()
                .map(TaskResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    // Get task details by ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable String id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(t -> ResponseEntity.ok(new TaskResponse(t)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Save or update task
    @PostMapping("/save")
    public ResponseEntity<TaskResponse> saveTask(@RequestBody TaskRequest taskRequest) {
        Task task = convertToEntity(taskRequest);
        Task savedTask = taskService.addTask(task);
        return ResponseEntity.ok(new TaskResponse(savedTask));
    }

    // Update task
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable String id, @RequestBody TaskRequest taskRequest) {
        Task task = convertToEntity(taskRequest);
        Task updatedTask = taskService.updateTask(id, task);

        if (updatedTask != null) {
            return ResponseEntity.ok(new TaskResponse(updatedTask));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        boolean deleted = taskService.deleteTask(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Helper method to convert DTO to entity
    private Task convertToEntity(TaskRequest taskRequest) {
        return new Task(
                taskRequest.getId(),
                taskRequest.getName(),
                taskRequest.getStartDate(),
                taskRequest.getEndDate(),
                taskRequest.getProgress(),
                taskRequest.getDependencies(),
                taskRequest.getDescription()
        );
    }

}
