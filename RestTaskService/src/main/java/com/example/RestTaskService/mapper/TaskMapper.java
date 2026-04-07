package com.example.RestTaskService.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.RestTaskService.config.MapStructConfig;
import com.example.RestTaskService.dto.request.task.CreateTaskRequest;
import com.example.RestTaskService.dto.request.task.UpdateTaskRequest;
import com.example.RestTaskService.dto.response.account.TaskInfo;
import com.example.RestTaskService.dto.response.task.CreateTaskResponse;
import com.example.RestTaskService.dto.response.task.GetTaskResponse;
import com.example.RestTaskService.dto.response.task.ReassignTaskResponse;
import com.example.RestTaskService.dto.response.task.UpdateTaskResponse;
import com.example.RestTaskService.model.Task;

@Mapper(config = MapStructConfig.class)
public interface TaskMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "account", ignore = true)
	Task toEntity(CreateTaskRequest request);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "account", ignore = true)
	Task toEntity(UpdateTaskRequest request);

	@Mapping(source = "account.id", target = "accountId")
	CreateTaskResponse toCreateResponse(Task task);

	@Mapping(source = "account.id", target = "accountId")
	GetTaskResponse toGetResponse(Task task);

	@Mapping(source = "account.id", target = "accountId")
	UpdateTaskResponse toUpdateResponse(Task task);

	@Mapping(source = "account.id", target = "accountId")
	ReassignTaskResponse toReassignResponse(Task task);
	
	TaskInfo toTaskInfo(Task task);
	
	List<GetTaskResponse> toGetTaskResponseList(List<Task> tasks);
}
