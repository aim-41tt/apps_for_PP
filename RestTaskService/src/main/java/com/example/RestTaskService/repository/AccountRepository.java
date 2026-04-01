package com.example.RestTaskService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.RestTaskService.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("SELECT a FROM Account a LEFT JOIN FETCH a.tasks WHERE a.id = :id")
	Optional<Account> findByIdWithTasks(@Param("id") Long id);
}
