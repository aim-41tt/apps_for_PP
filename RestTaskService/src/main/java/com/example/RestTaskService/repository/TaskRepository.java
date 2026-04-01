package com.example.RestTaskService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RestTaskService.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByAccountId(Long accountId);
}
