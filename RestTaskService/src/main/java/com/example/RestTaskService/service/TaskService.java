package com.example.RestTaskService.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RestTaskService.model.Account;
import com.example.RestTaskService.model.Task;
import com.example.RestTaskService.repository.TaskRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {

	private final TaskRepository taskRepository;
	private final AccountService accountService;

	@Transactional
	public Task createTask(Task task, Long accountId) {
		Account account = accountService.findAccountById(accountId);
		task.setAccount(account);
		return taskRepository.save(task);
	}

	@Transactional(readOnly = true)
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Task> getTasksByAccountId(Long accountId) {
		return taskRepository.findByAccountId(accountId);
	}

	@Transactional(readOnly = true)
	public Task getTaskById(Long id) {
		return findTaskById(id);
	}

	@Transactional
	public Task updateTask(Long id, Task request) {
		Task existingTask = findTaskById(id);
		existingTask.setTitle(request.getTitle());
		existingTask.setBody(request.getBody());
		existingTask.setCompleted(request.isCompleted());
		return taskRepository.save(existingTask);
	}

	@Transactional
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

	@Transactional
	public Task assignTaskToAccount(Long taskId, Long accountId) {
		Task task = findTaskById(taskId);

		if (task.getAccount() != null && task.getAccount().getId().equals(accountId)) {
			throw new IllegalArgumentException(
					"Задача с id: " + taskId + " уже прикреплена к аккаунту с id: " + accountId);
		}

		Account account = accountService.findAccountById(accountId);
		task.setAccount(account);
		return taskRepository.save(task);
	}

	private Task findTaskById(Long id) {
		return taskRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Задача не найдена с идентификатором: " + id));
	}
}
