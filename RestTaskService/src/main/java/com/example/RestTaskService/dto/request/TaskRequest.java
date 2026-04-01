package com.example.RestTaskService.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequest(
		@NotBlank(message = "Название задачи не может быть пустым")
		String title,

		@NotBlank(message = "Описание задачи не может быть пустым")
		String body,

		boolean completed,

		@NotNull(message = "Идентификатор аккаунта не может быть пустым")
		Long accountId
) {
}
