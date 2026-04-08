package com.example.RestTaskService.exception.handler;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.RestTaskService.dto.response.ErrorResponse;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorResponse handleEntityNotFoundException(EntityNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value(),
				OffsetDateTime.now(ZoneOffset.UTC)
		);
		return errorResponse;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
		String message = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getField() + ": " + error.getDefaultMessage())
				.collect(Collectors.joining("; "));

		ErrorResponse errorResponse = new ErrorResponse(
				"Ошибка валидации: " + message,
				HttpStatus.BAD_REQUEST.value(),
				OffsetDateTime.now(ZoneOffset.UTC)
		);
		return errorResponse;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ErrorResponse handleIllegalArgumentException(IllegalArgumentException ex) {
		ErrorResponse errorResponse = new ErrorResponse(
				ex.getMessage(),
				HttpStatus.CONFLICT.value(),
				OffsetDateTime.now(ZoneOffset.UTC)
		);
		return errorResponse;
	}
}
