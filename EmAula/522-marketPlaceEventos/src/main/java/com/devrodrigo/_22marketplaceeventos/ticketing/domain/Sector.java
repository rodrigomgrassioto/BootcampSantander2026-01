package com.devrodrigo._22marketplaceeventos.ticketing.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Sector {
    private final UUID id;
    private final SectorId corelationId;
    private final BigDecimal price;

    public Sector(String corelationId, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.corelationId = new SectorId(corelationId);
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public SectorId getCorelationId() {
        return corelationId;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
