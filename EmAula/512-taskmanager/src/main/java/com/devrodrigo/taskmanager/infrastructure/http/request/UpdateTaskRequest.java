package com.devrodrigo.taskmanager.infrastructure.http.request;

import com.devrodrigo.taskmanager.application.input.UpdateTaskInput;
import com.devrodrigo.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskRequest(
        Optional<String> title,
        Optional<String> description,
        Optional<String> status
) {
    public UpdateTaskInput toInput(){
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));
    }
}
