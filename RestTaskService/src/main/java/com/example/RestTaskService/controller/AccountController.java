package com.example.RestTaskService.controller;

import java.util.List;
import java.util.UUID;

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
import lombok.RequiredArgsConstructor;

import com.example.RestTaskService.dto.request.account.CreateAccountRequest;
import com.example.RestTaskService.dto.request.account.UpdateAccountRequest;
import com.example.RestTaskService.dto.response.account.CreateAccountResponse;
import com.example.RestTaskService.dto.response.account.GetAccountResponse;
import com.example.RestTaskService.dto.response.account.UpdateAccountResponse;
import com.example.RestTaskService.mapper.AccountMapper;
import com.example.RestTaskService.model.Account;
import com.example.RestTaskService.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

	private final AccountService accountService;
	private final AccountMapper accountMapper;

	@GetMapping
	public List<GetAccountResponse> getAllAccounts() {
		return accountMapper.toGetAccountResponseList(accountService.getAllAccounts());
	}

	@GetMapping("/{id}")
	public GetAccountResponse getAccountById(@PathVariable UUID id) {
		Account account = accountService.getAccountById(id);
		return accountMapper.toGetResponse(account);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateAccountResponse createAccount(@Valid @RequestBody CreateAccountRequest request) {
		Account account = accountMapper.toEntity(request);
		Account saved = accountService.createAccount(account);
		return accountMapper.toCreateResponse(saved);
	}

	@PutMapping("/{id}")
	public UpdateAccountResponse updateAccount(@PathVariable UUID id,
			@Valid @RequestBody UpdateAccountRequest request) {
		Account accountData = accountMapper.toEntity(request);
		Account updated = accountService.updateAccount(id, accountData);
		return accountMapper.toUpdateResponse(updated);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAccount(@PathVariable UUID id) {
		accountService.deleteAccount(id);
	}
}
