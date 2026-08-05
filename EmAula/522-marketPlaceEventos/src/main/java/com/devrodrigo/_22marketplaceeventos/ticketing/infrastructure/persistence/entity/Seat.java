package com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Seat {
    @Id
    private UUID id;
    private String correlationId;

    public Seat() {
    }

    public Seat(UUID id, String correlationId) {
        this.id = id;
        this.correlationId = correlationId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
