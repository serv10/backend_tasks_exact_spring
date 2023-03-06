package com.example.backend_tasks_spring.repositories;

import com.example.backend_tasks_spring.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUTaskRepository extends JpaRepository<TaskModel, Long> {
}
