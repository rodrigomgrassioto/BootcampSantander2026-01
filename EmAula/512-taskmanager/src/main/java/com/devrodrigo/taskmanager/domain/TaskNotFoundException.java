package com.devrodrigo.taskmanager.domain;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(TaskId taskId)
    {
        super("Tarefa com ID "+taskId+" não encontrada.");
    }
}
