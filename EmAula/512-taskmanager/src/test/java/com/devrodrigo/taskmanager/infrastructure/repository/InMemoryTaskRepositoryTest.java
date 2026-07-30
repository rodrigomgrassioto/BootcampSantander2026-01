package com.devrodrigo.taskmanager.infrastructure.repository;

import com.devrodrigo.taskmanager.domain.Task;
import com.devrodrigo.taskmanager.domain.TaskId;
import com.devrodrigo.taskmanager.domain.TaskRepository;
import com.devrodrigo.taskmanager.domain.TaskRepositoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class InMemoryTaskRepositoryTest extends TaskRepositoryTest {

    private InMemoryTaskRepository repository;

    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }
}