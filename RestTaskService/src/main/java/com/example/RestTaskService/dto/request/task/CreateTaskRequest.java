package com.example.RestTaskService.dto.request.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTaskRequest(
        @NotNull(message = "ID аккаунта обязателен")
        Long accountId,

        @NotBlank(message = "Заголовок задачи не может быть пустым")
        
        String title,

        @NotBlank(message = "Описание задачи не может быть пустым")
        String body,
        
        @NotNull
        Boolean completed
) {}