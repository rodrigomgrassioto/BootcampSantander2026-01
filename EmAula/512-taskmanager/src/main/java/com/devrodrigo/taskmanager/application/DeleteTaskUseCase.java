package com.devrodrigo.taskmanager.application;

import com.devrodrigo.taskmanager.domain.TaskId;
import com.devrodrigo.taskmanager.domain.TaskNotFoundExpetion;
import com.devrodrigo.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskUseCase {
    private final TaskRepository repository;

    public DeleteTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public void execute(TaskId taskId){
        if (repository.findById(taskId).isEmpty()){
            throw new TaskNotFoundExpetion(taskId);
        }
        repository.delete(taskId);
    }
}
