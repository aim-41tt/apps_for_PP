package com.example.RestTaskService.dto.request.task;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record ReassignTaskRequest(
        @NotNull(message = "ID задачи обязателен")
        UUID taskId,

        @NotNull(message = "ID целевого аккаунта обязателен")
        UUID targetAccountId
) {}