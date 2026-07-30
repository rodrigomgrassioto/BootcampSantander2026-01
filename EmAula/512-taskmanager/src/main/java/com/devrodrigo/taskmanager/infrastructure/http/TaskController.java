package com.devrodrigo.taskmanager.infrastructure.http;


import com.devrodrigo.taskmanager.application.CreateTaskUseCase;
import com.devrodrigo.taskmanager.application.input.CreateTaskInput;
import com.devrodrigo.taskmanager.infrastructure.http.request.CreateTaskRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
    }

    @PostMapping
    void create(@RequestBody CreateTaskRequest request) {
        var input = request.toInput();
        System.out.println(createTaskUseCase.execute(input));
    }
}
