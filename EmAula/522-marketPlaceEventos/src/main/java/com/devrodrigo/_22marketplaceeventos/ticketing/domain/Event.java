package com.devrodrigo._22marketplaceeventos.ticketing.domain;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Event {
    private final UUID id;
    private final EventId corelationId;
    private final Map<Sector, List<Seat>> seats;

    public Event(String corelationId, Map<Sector, List<Seat>> seats) {
        this.id = UUID.randomUUID();
        this.corelationId = new EventId(corelationId);
        this.seats = seats;
    }

    public UUID getId() {
        return id;
    }

    public EventId getCorelationId() {
        return corelationId;
    }

    public Map<Sector, List<Seat>> getSeats() {
        return seats;
    }
}
