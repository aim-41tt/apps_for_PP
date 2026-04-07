package com.example.RestTaskService.dto.request.task;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateTaskRequest(
        @NotNull(message = "ID аккаунта обязателен")
        UUID accountId,

        @Size(max = 70)
        @NotBlank(message = "Заголовок задачи не может быть пустым")
        String title,
        
        @Size(max = 600)
        @NotBlank(message = "Описание задачи не может быть пустым")
        String body,
        
        @NotNull
        Boolean completed
) {}