package com.example.RestTaskService.facade;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RestTaskService.model.Account;
import com.example.RestTaskService.model.Task;
import com.example.RestTaskService.service.AccountService;
import com.example.RestTaskService.service.TaskService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskFacade {

	private final TaskService taskService;
	private final AccountService accountService;

	@Transactional
	public Task createTask(Task task, UUID accountId) {
		Account account = accountService.findAccountById(accountId);
		task.setAccount(account);
		return taskService.saveTask(task);
	}

	@Transactional
	public Task assignTaskToAccount(UUID taskId, UUID accountId) {
		Task task = taskService.getTaskById(taskId);

		if (task.getAccount() != null && task.getAccount().getId().equals(accountId)) {
			return task;
		}

		Account account = accountService.findAccountById(accountId);
		task.setAccount(account);
		return task;
	}
}
