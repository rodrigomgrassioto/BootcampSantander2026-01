package com.devrodrigo._22marketplaceeventos.ticketing.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record CustomerId(UUID id) {

    public CustomerId {
        Assert.notNull(id, "Id não pode ser nulo");
    }

    public CustomerId(String id)
    {
        this(UUID.fromString(id));
    }
}
