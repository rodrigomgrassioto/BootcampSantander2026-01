package com.devrodrigo.taskmanager.application.input;

import com.devrodrigo.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskInput(Optional<String> title,
                              Optional<String> description,
                              Optional<TaskStatus> status) {}
