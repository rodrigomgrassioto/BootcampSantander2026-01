package com.devrodrigo.taskmanager.application;

import com.devrodrigo.taskmanager.application.input.CreateTaskInput;
import com.devrodrigo.taskmanager.application.output.TaskOutput;
import com.devrodrigo.taskmanager.infrastructure.repository.InMemoryTaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CreateTaskUseCaseTest {
    @Autowired
    CreateTaskUseCase useCase;

    /* não é mais necessário esse bloco após anotar
    1 - @Service em CreateTaskUseCase
    2 -  @Repository em InMemoryTaskRepository
    3 -  @Autowired e @SpringBootTest aqui
    @BeforeEach
    void setUp(){
        this.useCase = new CreateTaskUseCase(new InMemoryTaskRepository());
    } */

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