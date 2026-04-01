package com.example.RestTaskService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.RestTaskService.dto.request.TaskRequest;
import com.example.RestTaskService.dto.response.TaskResponse;
import com.example.RestTaskService.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping
	public List<TaskResponse> getAllTasks() {
		return taskService.getAllTasks();
	}

	@GetMapping("/{id}")
	public TaskResponse getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TaskResponse createTask(@Valid @RequestBody TaskRequest request) {
		return taskService.createTask(request);
	}

	@PutMapping("/{id}")
	public TaskResponse updateTask(@PathVariable Long id, @Valid @RequestBody TaskRequest request) {
		return taskService.updateTask(id, request);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
	}

	@PutMapping("/{taskId}/assign/{accountId}")
	public TaskResponse assignTaskToAccount(@PathVariable Long taskId, @PathVariable Long accountId) {
		return taskService.assignTaskToAccount(taskId, accountId);
	}
}
