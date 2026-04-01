package com.example.RestTaskService.dto;

import java.time.LocalDateTime;

public record CustomErrorResponse(String message, int status, LocalDateTime timestamp) {

}
