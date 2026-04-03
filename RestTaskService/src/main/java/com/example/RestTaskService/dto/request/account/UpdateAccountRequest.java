package com.example.RestTaskService.dto.request.account;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record UpdateAccountRequest(
        @NotBlank(message = "Имя не может быть пустым")
        @Size(max = 100, message = "Имя не может превышать 100 символов")
        String name,

        @NotBlank(message = "Фамилия не может быть пустой")
        @Size(max = 100, message = "Фамилия не может превышать 100 символов")
        String surname,

        @Max(value = 200, message = "Возраст не может быть столь большим")
        @PositiveOrZero(message = "Возраст не может быть отрицательным")
        int age
) {}