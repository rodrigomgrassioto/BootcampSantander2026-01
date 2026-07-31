package com.devrodrigo.taskmanager.application;

import com.devrodrigo.taskmanager.application.output.TaskOutput;
import com.devrodrigo.taskmanager.domain.TaskId;
import com.devrodrigo.taskmanager.domain.TaskNotFoundException;
import com.devrodrigo.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id){
        return repository.findById(id).map(TaskOutput::from).orElseThrow(()-> new TaskNotFoundException(id));
    }
}
