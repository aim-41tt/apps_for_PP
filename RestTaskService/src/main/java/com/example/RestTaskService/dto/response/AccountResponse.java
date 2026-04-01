package com.example.RestTaskService.dto.response;

import java.util.List;

public record AccountResponse(Long id, String name, String surname, int age, List<TaskResponse> tasks) {
}
