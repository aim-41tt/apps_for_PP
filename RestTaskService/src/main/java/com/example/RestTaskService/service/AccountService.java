package com.example.RestTaskService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RestTaskService.model.Account;
import com.example.RestTaskService.repository.AccountRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService {

	private final AccountRepository accountRepository;

	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	public Account getAccountById(UUID id) {
		return accountRepository.findByIdWithTasks(id)
				.orElseThrow(() -> new EntityNotFoundException("Аккаунт с id: " + id + " не найден"));
	}
	
	@Transactional
	public Account updateAccount(UUID id, Account request) {
		Account existingAccount = findAccountById(id);
		existingAccount.setName(request.getName());
		existingAccount.setSurname(request.getSurname());
		existingAccount.setAge(request.getAge());
		return existingAccount;
	}

	public void deleteAccount(UUID id) {
		accountRepository.deleteById(id);
	}

	public Account findAccountById(UUID id) {
		return accountRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Аккаунт с id: " + id + " не найден"));
	}
}
