package com.devrodrigo.taskmanager.application;

import com.devrodrigo.taskmanager.application.input.CreateTaskInput;
import com.devrodrigo.taskmanager.application.output.TaskOutput;
import com.devrodrigo.taskmanager.domain.Task;
import com.devrodrigo.taskmanager.domain.TaskRepository;
import com.devrodrigo.taskmanager.infrastructure.repository.InMemoryTaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CreateTaskUseCaseTest {
    @Mock
    TaskRepository repository;

//    @Autowired // não necessário após usar o mock
    @InjectMocks
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

        /* Simula chamada do repositório, onde responde com o argumento que entrou. ????
        Podendo simular resposta do repository sem realmente salvar no banco de dados, ou
        se for uma API simular a resposta dela */
        when(repository.save(any(Task.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));


        TaskOutput output = useCase.execute(input);

        assertNotNull(output);
        assertNotNull(output.id());
        assertEquals("Estudar java", output.title());
        assertEquals(Optional.of("Antes reiniciar notebook"), output.description());

        // verfica se o repository foi chamado apenas 1 vez
        verify(repository, times(1)).save(any(Task.class));
    }
}