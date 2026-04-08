package com.example.RestTaskService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RestTaskService.model.Task;
import com.example.RestTaskService.repository.TaskRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {

	private final TaskRepository taskRepository;

	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public List<Task> getTasksByAccountId(UUID accountId) {
		return taskRepository.findByAccountId(accountId);
	}

	@Transactional(readOnly = true)
	public Task getTaskById(UUID id) {
		return taskRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Задача не найдена с идентификатором: " + id));
	}

	@Transactional
	public Task updateTask(UUID id, Task request) {
		Task existingTask = getTaskById(id);
		existingTask.setTitle(request.getTitle());
		existingTask.setBody(request.getBody());
		existingTask.setCompleted(request.isCompleted());
		return existingTask;
	}

	public void deleteTask(UUID id) {
		taskRepository.deleteById(id);
	}


}
