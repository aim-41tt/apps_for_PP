package com.example.RestTaskService.dto.response.task;

public record UpdateTaskResponse(Long id, Long accountId, String title, String body, boolean completed) {
}
