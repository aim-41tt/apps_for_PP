package com.example.RestTaskService.mapper;

import org.springframework.stereotype.Component;

import com.example.RestTaskService.dto.request.TaskRequest;
import com.example.RestTaskService.dto.response.TaskResponse;
import com.example.RestTaskService.model.Account;
import com.example.RestTaskService.model.Task;

@Component
public class TaskMapper {

	public Task toEntity(TaskRequest request) {
		Task task = new Task();
		task.setTitle(request.title());
		task.setBody(request.body());
		task.setCompleted(request.completed());

		Account account = new Account();
		account.setId(request.accountId());
		task.setAccount(account);

		return task;
	}

	public TaskResponse toResponse(Task task) {
		return new TaskResponse(
				task.getId(),
				task.getTitle(),
				task.getBody(),
				task.isCompleted(),
				task.getAccount().getId()
		);
	}
}
