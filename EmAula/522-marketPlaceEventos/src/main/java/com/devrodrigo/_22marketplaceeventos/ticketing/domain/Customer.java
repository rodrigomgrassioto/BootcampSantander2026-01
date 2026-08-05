package com.devrodrigo._22marketplaceeventos.ticketing.domain;

import java.util.UUID;

public class Customer {
    private UUID id;
    private CustomerId currelationId;
    private String name;

    public Customer(String correlationId, String name) {
        this.id = UUID.randomUUID();
        this.currelationId = new CustomerId(correlationId);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CustomerId getCurrelationId() {
        return currelationId;
    }

    public UUID getId() {
        return id;
    }
}
