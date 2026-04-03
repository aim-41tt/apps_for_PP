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

import com.example.RestTaskService.dto.request.task.CreateTaskRequest;
import com.example.RestTaskService.dto.request.task.UpdateTaskRequest;
import com.example.RestTaskService.dto.response.task.CreateTaskResponse;
import com.example.RestTaskService.dto.response.task.GetTaskResponse;
import com.example.RestTaskService.dto.response.task.ReassignTaskResponse;
import com.example.RestTaskService.dto.response.task.UpdateTaskResponse;
import com.example.RestTaskService.mapper.TaskMapper;
import com.example.RestTaskService.model.Task;
import com.example.RestTaskService.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	private final TaskService taskService;
	private final TaskMapper taskMapper;

	public TaskController(TaskService taskService, TaskMapper taskMapper) {
		this.taskService = taskService;
		this.taskMapper = taskMapper;
	}

	@GetMapping
	public List<GetTaskResponse> getAllTasks() {
		return taskService.getAllTasks().stream()
				.map(taskMapper::toGetResponse)
				.toList();
	}

	@GetMapping("/{id}")
	public GetTaskResponse getTaskById(@PathVariable Long id) {
		Task task = taskService.getTaskById(id);
		return taskMapper.toGetResponse(task);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateTaskResponse createTask(@Valid @RequestBody CreateTaskRequest request) {
		Task task = taskMapper.toEntity(request);
		Task saved = taskService.createTask(task, request.accountId());
		return taskMapper.toCreateResponse(saved);
	}

	@PutMapping("/{id}")
	public UpdateTaskResponse updateTask(@PathVariable Long id,
			@Valid @RequestBody UpdateTaskRequest request) {
		Task taskData = taskMapper.toEntity(request);
		Task updated = taskService.updateTask(id, taskData);
		return taskMapper.toUpdateResponse(updated);
	}

	@PutMapping("/{taskId}/assign/{accountId}")
	public ReassignTaskResponse assignTaskToAccount(@PathVariable Long taskId, @PathVariable Long accountId) {
		Task reassigned = taskService.assignTaskToAccount(taskId, accountId);
		return taskMapper.toReassignResponse(reassigned);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
	}
}
