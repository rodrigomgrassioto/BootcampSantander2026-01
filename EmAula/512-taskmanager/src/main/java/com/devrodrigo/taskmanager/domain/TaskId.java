package com.devrodrigo.taskmanager.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record TaskId(UUID id) {

    public TaskId {
        Assert.notNull(id, "Id não pode ser nulo.");
    }

    public TaskId(){
        this(UUID.randomUUID());
    }
}
