package com.example.backend_tasks_spring.controllers;

import com.example.backend_tasks_spring.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.backend_tasks_spring.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ArrayList<TaskModel> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/tasks")
    public TaskModel saveTask(@RequestBody TaskModel request) {
        return taskService.saveTask(request);
    }

    @PutMapping("/tasks/{id}")
    public TaskModel toggleCompleteTask(@PathVariable("id") Long id) {
        return taskService.toggleCompleteTask(id);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteModel(@PathVariable("id") Long id) {
        boolean ok = taskService.deleteTask(id);

        if (ok) {
            return "Task with " + id + " was deleted";
        }

        return "Error to eliminate task with id " + id;
    }
}
