package com.devrodrigo.taskmanager.application;

import com.devrodrigo.taskmanager.application.output.TaskOutput;
import com.devrodrigo.taskmanager.domain.TaskRepository;
import com.devrodrigo.taskmanager.infrastructure.repository.InMemoryTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTasksUseCase {
    private final TaskRepository repository;

    public GetTasksUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskOutput> execute(){
        return repository.findAll().stream().map(TaskOutput::from).toList();
    }
}
