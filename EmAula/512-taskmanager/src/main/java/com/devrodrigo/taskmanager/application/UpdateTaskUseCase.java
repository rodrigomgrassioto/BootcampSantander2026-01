package com.devrodrigo.taskmanager.application;

import com.devrodrigo.taskmanager.application.input.UpdateTaskInput;
import com.devrodrigo.taskmanager.application.output.TaskOutput;
import com.devrodrigo.taskmanager.domain.TaskId;
import com.devrodrigo.taskmanager.domain.TaskNotFoundExpetion;
import com.devrodrigo.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId taskId, UpdateTaskInput input){
        var task = repository.findById(taskId).orElseThrow(() -> new TaskNotFoundExpetion(taskId));
        task.update(input.title(), input.description(), input.status());

        var updated = repository.save(task);
        return TaskOutput.from(updated);
    }
}
