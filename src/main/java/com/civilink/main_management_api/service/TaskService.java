package com.civilink.main_management_api.service;

import com.civilink.main_management_api.entity.Task;
import com.civilink.main_management_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;


    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(String id, Task updatedTask) {
        // Check if task exists
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            updatedTask.setId(id);
            return taskRepository.save(updatedTask);
        }
        return null;
    }

    public boolean deleteTask(String id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }




    // Method to create an empty task with default values
    public Task createEmptyTask() {
        Task task = new Task();
        return taskRepository.save(task);
    }
}
