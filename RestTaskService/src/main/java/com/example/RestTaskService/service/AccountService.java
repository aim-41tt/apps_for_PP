package com.example.RestTaskService.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RestTaskService.dto.request.AccountRequest;
import com.example.RestTaskService.dto.response.AccountResponse;
import com.example.RestTaskService.mapper.AccountMapper;
import com.example.RestTaskService.model.Account;
import com.example.RestTaskService.repository.AccountRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	private final AccountMapper accountMapper;

	public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
		this.accountRepository = accountRepository;
		this.accountMapper = accountMapper;
	}

	@Transactional
	public AccountResponse createAccount(AccountRequest request) {
		Account account = accountMapper.toEntity(request);
		return accountMapper.toResponse(accountRepository.save(account));
	}

	@Transactional(readOnly = true)
	public List<AccountResponse> getAllAccounts() {
		return accountRepository.findAll().stream()
				.map(accountMapper::toResponse)
				.toList();
	}

	@Transactional(readOnly = true)
	public AccountResponse getAccountById(Long id) {
		Account account = accountRepository.findByIdWithTasks(id)
				.orElseThrow(() -> new EntityNotFoundException("Аккаунт с id: " + id + " не найден"));
		return accountMapper.toResponseWithTasks(account);
	}

	@Transactional
	public AccountResponse updateAccount(Long id, AccountRequest request) {
		Account existingAccount = findAccountById(id);
		existingAccount.setName(request.name());
		existingAccount.setSurname(request.surname());
		existingAccount.setAge(request.age());
		return accountMapper.toResponse(accountRepository.save(existingAccount));
	}

	@Transactional
	public void deleteAccount(Long id) {
		Account account = findAccountById(id);
		accountRepository.delete(account);
	}

	@Transactional(readOnly = true)
	public Account findAccountById(Long id) {
		return accountRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Аккаунт с id: " + id + " не найден"));
	}
}
