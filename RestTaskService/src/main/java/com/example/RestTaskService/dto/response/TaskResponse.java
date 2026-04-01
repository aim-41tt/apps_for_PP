package com.example.RestTaskService.dto.response;

public record TaskResponse(Long id,String title,String body,boolean completed,Long accountId) {

}
