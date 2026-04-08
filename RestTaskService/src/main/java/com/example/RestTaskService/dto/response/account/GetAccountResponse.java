package com.example.RestTaskService.dto.response.account;

import java.util.List;
import java.util.UUID;

import com.example.RestTaskService.dto.TaskInfo;

public record GetAccountResponse(UUID id, String name, String surname, int age, List<TaskInfo> tasks) {
}