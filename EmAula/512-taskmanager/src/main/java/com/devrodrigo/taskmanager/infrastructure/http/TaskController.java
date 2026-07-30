package com.devrodrigo.taskmanager.infrastructure.http;


import com.devrodrigo.taskmanager.application.CreateTaskUseCase;
import com.devrodrigo.taskmanager.infrastructure.http.request.CreateTaskRequest;
import com.devrodrigo.taskmanager.infrastructure.http.response.TaskResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
    }

    @PostMapping
    TaskResponse create(@RequestBody CreateTaskRequest request) {
        var input = request.toInput();
        var output =  createTaskUseCase.execute(input);
        return TaskResponse.from(output);
    }
}
