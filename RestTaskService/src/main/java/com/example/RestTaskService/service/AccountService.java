package com.example.RestTaskService.service;

import java.util.List;

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

	@Transactional
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Transactional(readOnly = true)
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Account getAccountById(Long id) {
		return accountRepository.findByIdWithTasks(id)
				.orElseThrow(() -> new EntityNotFoundException("Аккаунт с id: " + id + " не найден"));
	}

	@Transactional
	public Account updateAccount(Long id, Account request) {
		Account existingAccount = findAccountById(id);
		existingAccount.setName(request.getName());
		existingAccount.setSurname(request.getSurname());
		existingAccount.setAge(request.getAge());
		return accountRepository.save(existingAccount);
	}

	@Transactional
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Account findAccountById(Long id) {
		return accountRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Аккаунт с id: " + id + " не найден"));
	}
}
