package com.example.RestTaskService.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.RestTaskService.dto.request.AccountRequest;
import com.example.RestTaskService.dto.response.AccountResponse;
import com.example.RestTaskService.dto.response.TaskResponse;
import com.example.RestTaskService.model.Account;

@Component
public class AccountMapper {

	private final TaskMapper taskMapper;

	public AccountMapper(TaskMapper taskMapper) {
		this.taskMapper = taskMapper;
	}

	public Account toEntity(AccountRequest request) {
		Account account = new Account();
		account.setName(request.name());
		account.setSurname(request.surname());
		account.setAge(request.age());
		return account;
	}

	public AccountResponse toResponse(Account account) {
		return new AccountResponse(
				account.getId(),
				account.getName(),
				account.getSurname(),
				account.getAge(),
				List.of()
		);
	}

	public AccountResponse toResponseWithTasks(Account account) {
		List<TaskResponse> tasks = account.getTasks().stream()
				.map(taskMapper::toResponse)
				.toList();

		return new AccountResponse(
				account.getId(),
				account.getName(),
				account.getSurname(),
				account.getAge(),
				tasks
		);
	}
}
