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

import com.example.RestTaskService.dto.request.AccountRequest;
import com.example.RestTaskService.dto.response.AccountResponse;
import com.example.RestTaskService.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping
	public List<AccountResponse> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AccountResponse createAccount(@Valid @RequestBody AccountRequest request) {
		return accountService.createAccount(request);
	}

	@GetMapping("/{id}")
	public AccountResponse getAccountById(@PathVariable Long id) {
		return accountService.getAccountById(id);
	}

	@PutMapping("/{id}")
	public AccountResponse updateAccount(@PathVariable Long id, @Valid @RequestBody AccountRequest request) {
		return accountService.updateAccount(id, request);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAccount(@PathVariable Long id) {
		accountService.deleteAccount(id);
	}
}
