package com.devrodrigo.taskmanager.application;

import com.devrodrigo.taskmanager.application.input.CreateTaskInput;
import com.devrodrigo.taskmanager.application.output.TaskOutput;
import com.devrodrigo.taskmanager.domain.Task;
import com.devrodrigo.taskmanager.domain.TaskRepository;

public class CreateTaskUseCase {
    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input) {
        var task =  new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutput.from(saved);
    }
}
