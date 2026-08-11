package com.example.RestTaskService.dto.response.account;

import java.util.UUID;

public record CreateAccountResponse(UUID id, String name, String surname, int age) {

}
