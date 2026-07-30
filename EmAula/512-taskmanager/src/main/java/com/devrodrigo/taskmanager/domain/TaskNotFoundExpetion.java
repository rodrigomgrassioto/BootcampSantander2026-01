package com.devrodrigo.taskmanager.domain;

public class TaskNotFoundExpetion extends RuntimeException {
    public TaskNotFoundExpetion(TaskId taskId)
    {
        super("Tarefa com ID "+taskId+" não encontrada.");
    }
}
