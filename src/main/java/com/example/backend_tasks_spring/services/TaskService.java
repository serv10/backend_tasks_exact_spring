package com.example.backend_tasks_spring.services;

import com.example.backend_tasks_spring.model.TaskModel;
import com.example.backend_tasks_spring.repositories.IUTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TaskService {
    @Autowired
    IUTaskRepository taskRepository;

    public ArrayList<TaskModel> getTasks() {
        return (ArrayList<TaskModel>) taskRepository.findAll();
    }

    public TaskModel saveTask(TaskModel task) {
        return taskRepository.save(task);
    }

    public TaskModel toggleCompleteTask(Long id) {
        TaskModel task = taskRepository.findById(id).get();
        boolean completed = task.getCompleted();
        if (!completed){
            task.setCompleted(true);
        } else {
            task.setCompleted(false);
        }
        taskRepository.save(task);
        return task;
    }

    public boolean deleteTask (Long id){
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
