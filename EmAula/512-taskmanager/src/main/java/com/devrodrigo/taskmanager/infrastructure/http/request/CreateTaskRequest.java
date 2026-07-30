package com.devrodrigo.taskmanager.infrastructure.http.request;

import java.util.Optional;

public record CreateTaskRequest(String title, Optional<String> description) {

}
