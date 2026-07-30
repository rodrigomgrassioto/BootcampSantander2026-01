package com.devrodrigo.taskmanager.infrastructure.http;


import com.devrodrigo.taskmanager.application.CreateTaskUseCase;
import com.devrodrigo.taskmanager.application.input.CreateTaskInput;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
    }

    @PostMapping
    void create() {
        var input = new CreateTaskInput("Renovar passaporte", Optional.empty());
        createTaskUseCase.execute(input);
    }
}
