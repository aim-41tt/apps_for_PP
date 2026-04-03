package com.example.RestTaskService.dto.response.task;

public record GetTaskResponse(Long id, Long accountId, String title, String body, boolean completed) {
}
