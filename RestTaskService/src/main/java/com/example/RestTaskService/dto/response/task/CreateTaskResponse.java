package com.example.RestTaskService.dto.response.task;

public record CreateTaskResponse(Long id, Long accountId, String title, String body, boolean completed) {

}
