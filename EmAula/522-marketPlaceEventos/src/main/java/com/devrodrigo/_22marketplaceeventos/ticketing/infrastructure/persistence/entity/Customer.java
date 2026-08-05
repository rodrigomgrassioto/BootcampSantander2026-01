package com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
public class Customer {
    @Id
    private UUID id;
    private UUID correlationId;

    @NotBlank
    @Column(nullable = false)
    private String name;

    public Customer() {
    }

    public Customer(UUID id, UUID correlationId, String name) {
        this.id = id;
        this.correlationId = correlationId;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(UUID correlationId) {
        this.correlationId = correlationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
