package com.devrodrigo._22marketplaceeventos.ticketing.domain;

import com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.repository.CustomerCrudRepository;
import org.springframework.util.Assert;

import java.util.UUID;

public record EventId (UUID id){
    public EventId{
        Assert.notNull(id, "id não pode ser null");
    }

    public EventId(String id){
        this(UUID.fromString(id));
    }
}
