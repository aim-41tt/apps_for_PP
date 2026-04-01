package com.example.RestTaskService.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RestTaskService.dto.request.TaskRequest;
import com.example.RestTaskService.dto.response.TaskResponse;
import com.example.RestTaskService.mapper.TaskMapper;
import com.example.RestTaskService.model.Account;
import com.example.RestTaskService.model.Task;
import com.example.RestTaskService.repository.TaskRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {
	private final TaskRepository taskRepository;
	private final AccountService accountService;
	private final TaskMapper taskMapper;

	public TaskService(TaskRepository taskRepository, AccountService accountService, TaskMapper taskMapper) {
		this.taskRepository = taskRepository;
		this.accountService = accountService;
		this.taskMapper = taskMapper;
	}

	@Transactional
	public TaskResponse createTask(TaskRequest request) {
		Account account = accountService.findAccountById(request.accountId());
		Task task = taskMapper.toEntity(request);
		task.setAccount(account);
		return taskMapper.toResponse(taskRepository.save(task));
	}

	@Transactional(readOnly = true)
	public List<TaskResponse> getAllTasks() {
		return taskRepository.findAll().stream()
				.map(taskMapper::toResponse)
				.toList();
	}

	@Transactional(readOnly = true)
	public List<TaskResponse> getTasksByAccountId(Long accountId) {
		return taskRepository.findByAccountId(accountId).stream()
				.map(taskMapper::toResponse)
				.toList();
	}

	@Transactional(readOnly = true)
	public TaskResponse getTaskById(Long id) {
		Task task = findTaskById(id);
		return taskMapper.toResponse(task);
	}

	@Transactional
	public TaskResponse updateTask(Long id, TaskRequest request) {
		Task existingTask = findTaskById(id);
		existingTask.setTitle(request.title());
		existingTask.setBody(request.body());
		existingTask.setCompleted(request.completed());
		return taskMapper.toResponse(taskRepository.save(existingTask));
	}

	@Transactional
	public void deleteTask(Long id) {
		Task task = findTaskById(id);
		taskRepository.delete(task);
	}

	@Transactional
	public TaskResponse assignTaskToAccount(Long taskId, Long accountId) {
		Task task = findTaskById(taskId);

		if (task.getAccount() != null && task.getAccount().getId().equals(accountId)) {
			throw new IllegalArgumentException(
					"Задача с id: " + taskId + " уже прикреплена к аккаунту с id: " + accountId);
		}

		Account account = accountService.findAccountById(accountId);
		task.setAccount(account);
		return taskMapper.toResponse(taskRepository.save(task));
	}

	private Task findTaskById(Long id) {
		return taskRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Задача не найдена с идентификатором: " + id));
	}
}
