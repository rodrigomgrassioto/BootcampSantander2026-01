package com.devrodrigo.taskmanager.application;

import com.devrodrigo.taskmanager.application.input.CreateTaskInput;
import com.devrodrigo.taskmanager.application.output.TaskOutput;
import com.devrodrigo.taskmanager.infrastructure.repository.InMemoryTaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CreateTaskUseCaseTest {
    CreateTaskUseCase useCase;

    @BeforeEach
    void setUp(){
        this.useCase = new CreateTaskUseCase(new InMemoryTaskRepository());
    }

    @Test
    void execute(){
        var input = new CreateTaskInput("Estudar java", Optional.of("Antes reiniciar notebook"));

        TaskOutput output = useCase.execute(input);

        assertNotNull(output);
        assertNotNull(output.id());
        assertEquals("Estudar java", output.title());
        assertEquals(Optional.of("Antes reiniciar notebook"), output.description());
    }
}