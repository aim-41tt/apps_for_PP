package com.example.RestTaskService.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.RestTaskService.model.Account;

public interface AccountRepository extends JpaRepository<Account, UUID> {

	@Query("SELECT a FROM Account a LEFT JOIN FETCH a.tasks WHERE a.id = :id")
	Optional<Account> findByIdWithTasks(@Param("id") UUID id);
}
