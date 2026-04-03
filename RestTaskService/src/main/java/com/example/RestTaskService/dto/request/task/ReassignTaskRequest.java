package com.example.RestTaskService.dto.request.task;

import jakarta.validation.constraints.NotNull;

public record ReassignTaskRequest(
        @NotNull(message = "ID задачи обязателен")
        Long taskId,

        @NotNull(message = "ID целевого аккаунта обязателен")
        Long targetAccountId
) {}