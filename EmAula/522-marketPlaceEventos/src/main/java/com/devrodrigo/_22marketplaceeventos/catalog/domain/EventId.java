package com.devrodrigo._22marketplaceeventos.catalog.domain;

import java.io.Serializable;
import java.util.UUID;

public record EventId(UUID id) {
    public EventId() {
        this(UUID.randomUUID());
    }
}
