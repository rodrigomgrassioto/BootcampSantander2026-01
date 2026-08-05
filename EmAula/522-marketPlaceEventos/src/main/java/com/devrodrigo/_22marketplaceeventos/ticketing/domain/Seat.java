package com.devrodrigo._22marketplaceeventos.ticketing.domain;

import java.util.UUID;

public class Seat {
    private final UUID id;
    private final SeatId correlationId;

    public Seat(String correlationId) {
        this.id = UUID.randomUUID();
        this.correlationId = new SeatId(correlationId);
    }

    public UUID getId() {
        return id;
    }

    public SeatId getCorrelationId() {
        return correlationId;
    }
}
