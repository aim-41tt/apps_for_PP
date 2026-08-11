package com.example.RestTaskService.dto.response.task;

import java.util.UUID;

public record UpdateTaskResponse(UUID id, UUID accountId, String title, String body, boolean completed) {
}
