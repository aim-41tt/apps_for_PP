package com.example.RestTaskService.dto.response;

import java.time.OffsetDateTime;

public record ErrorResponse(String message, int status, OffsetDateTime timestamp) {

}
