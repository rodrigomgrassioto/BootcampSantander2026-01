package com.devrodrigo.taskmanager.application;

import com.devrodrigo.taskmanager.application.input.CreateTaskInput;
import com.devrodrigo.taskmanager.domain.Task;

public class CreateTaskUseCase {
    void execute(CreateTaskInput input) {
        var task =  new Task(input.title(), input.description());
        // repository
    }
}
