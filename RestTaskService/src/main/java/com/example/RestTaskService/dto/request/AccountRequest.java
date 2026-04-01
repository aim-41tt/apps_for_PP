package com.example.RestTaskService.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AccountRequest(
		@NotBlank(message = "Имя не может быть пустым")
		@Size(max = 100, message = "Имя не может превышать 100 символов")
		String name,

		@NotBlank(message = "Фамилия не может быть пустой")
		@Size(max = 100, message = "Фамилия не может превышать 100 символов")
		String surname,

		@Min(value = 0, message = "Возраст не может быть отрицательным")
		int age
) {
}
