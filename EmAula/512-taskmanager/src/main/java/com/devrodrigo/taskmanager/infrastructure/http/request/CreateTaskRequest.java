package com.devrodrigo.taskmanager.infrastructure.http.request;

import com.devrodrigo.taskmanager.application.input.CreateTaskInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public record CreateTaskRequest(
        @NotBlank(message = "Título é obrigatório, não pode ficar em branco.")
        @Size(min = 3, max = 100, message = "O título deve conter entre {min} e {max} caracteres.")
        String title,

        Optional<@Size(max = 500) String> description) {
    public CreateTaskInput toInput() {
        return new CreateTaskInput(title, description);
    }
}
