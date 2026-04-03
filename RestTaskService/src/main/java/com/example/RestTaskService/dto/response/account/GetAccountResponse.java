package com.example.RestTaskService.dto.response.account;

import java.util.List;

import com.example.RestTaskService.dto.response.task.GetTaskResponse;

public record GetAccountResponse(Long id, String name, String surname, int age, List<GetTaskResponse> tasks) {
}