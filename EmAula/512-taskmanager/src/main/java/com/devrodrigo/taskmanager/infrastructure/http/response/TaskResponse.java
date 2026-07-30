package com.devrodrigo.taskmanager.infrastructure.http.response;

import com.devrodrigo.taskmanager.application.output.TaskOutput;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_ABSENT) // Remove campos nulos e também Optionals vazios do JSON
public record TaskResponse(String id, String title, String description, String status) {
    public static TaskResponse from(TaskOutput taskOutput) {
        return new TaskResponse(taskOutput.id(),
                taskOutput.title(),
                taskOutput.description().orElse(null),
                taskOutput.status());
    }
}
