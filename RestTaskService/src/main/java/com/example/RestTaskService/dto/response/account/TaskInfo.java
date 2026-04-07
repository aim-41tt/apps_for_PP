package com.example.RestTaskService.dto.response.account;

import java.util.UUID;

public record TaskInfo(UUID id, UUID accountId, String title, String body, boolean completed) {

}
