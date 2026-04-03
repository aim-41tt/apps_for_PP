package com.example.RestTaskService.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.RestTaskService.dto.request.account.CreateAccountRequest;
import com.example.RestTaskService.dto.request.account.UpdateAccountRequest;
import com.example.RestTaskService.dto.response.account.CreateAccountResponse;
import com.example.RestTaskService.dto.response.account.GetAccountResponse;
import com.example.RestTaskService.dto.response.account.UpdateAccountResponse;
import com.example.RestTaskService.model.Account;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface AccountMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "tasks", ignore = true)
	Account toEntity(CreateAccountRequest request);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "tasks", ignore = true)
	Account toEntity(UpdateAccountRequest request);

	CreateAccountResponse toCreateResponse(Account account);

	UpdateAccountResponse toUpdateResponse(Account account);

	GetAccountResponse toGetResponse(Account account);
}
