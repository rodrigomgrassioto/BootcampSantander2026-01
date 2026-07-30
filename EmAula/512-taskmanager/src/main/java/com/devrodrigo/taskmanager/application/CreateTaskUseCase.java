package com.devrodrigo.taskmanager.application;

import com.devrodrigo.taskmanager.application.input.CreateTaskInput;
import com.devrodrigo.taskmanager.application.output.TaskOutput;
import com.devrodrigo.taskmanager.domain.Task;
import com.devrodrigo.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateTaskUseCase {
    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input) {
        var task =  new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutput.from(saved);
//        return new TaskOutput("23ksj", "Teste", Optional.of("ERa uma vez"), "PENDING");
    }
}
