package com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Event {
    @Id
    private UUID id;
    private UUID correlationId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="event_id")
    private List<Sector> sectors = new ArrayList<>();

    public Event() {
    }

    public Event(UUID id, UUID correlationId, List<Sector> sectors) {
        this.id = id;
        this.correlationId = correlationId;
        this.sectors = sectors;
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

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }
}
