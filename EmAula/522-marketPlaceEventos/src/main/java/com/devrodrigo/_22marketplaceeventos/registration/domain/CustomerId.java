package com.devrodrigo._22marketplaceeventos.registration.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record CustomerId(UUID id) {

    public CustomerId {
        Assert.notNull(id, "Id não pode ser nulo");
    }

    public CustomerId() {
        this(UUID.randomUUID());
    }
}
