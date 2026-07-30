package com.devrodrigo.taskmanager.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class TaskRepositoryTest {
    TaskRepository repository;
    protected abstract TaskRepository createRepository();

    @BeforeEach
    public void setUp(){
        this.repository = createRepository();
    }

    @Test
    void save() { // testa o save incluindo o id
        var task = new Task("Passar na padaria", Optional.empty());
        var saved = repository.save(task);
//        System.out.println(saved.toString());
        Optional<Task> result = repository.findById(saved.getId());

        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(task.getId());
        assertThat(result.get().getDescription()).isEqualTo(task.getDescription());
        assertThat(result.get().getStatus()).isEqualTo(task.getStatus());
    }

    @Test
    void findAll() {
        var task = new Task("Arrumar piso da área", Optional.of("Comprar areia"));
        var task2 = new Task("Tampar buraco do cano de esgoto", Optional.of("Em hora com pouco sol."));

        repository.save(task);
        repository.save(task2);

        List<Task> tasks = repository.findAll();
        assertThat(tasks).hasSize(2);
        assertThat(tasks).extracting(Task::getId).containsExactlyInAnyOrder(task.getId(), task2.getId());
    }

    @Test
    void findById() {
        var noExistId = new TaskId();
        Optional<Task> result = repository.findById(noExistId);

        assertThat(result).isEmpty();

        var task = repository.save(new Task("Fazer um bolo de chocolate", Optional.of("Sem açúcar")));
        var taskId = task.getId();
        Optional<Task> result2 = repository.findById(taskId);

        assertThat(result2).isPresent();
        assertThat(result2.get().getId()).isEqualTo(task.getId());
        assertThat(result2.get().getDescription()).isEqualTo(task.getDescription());
        assertThat(result2.get().getStatus()).isEqualTo(task.getStatus());
    }

    @Test
    void delete() {
        var task = repository.save(new Task("Fazer um bolo de chocolate", Optional.of("Sem açúcar")));
        var taskId = task.getId();

        repository.delete(taskId);
        Optional<Task> result = repository.findById(taskId);

        assertThat(result).isEmpty();
    }
}