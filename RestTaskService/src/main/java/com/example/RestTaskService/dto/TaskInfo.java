package com.example.RestTaskService.dto;

import java.util.UUID;

public record TaskInfo(UUID id, UUID accountId, String title, String body, boolean completed) {

}
