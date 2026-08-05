package com.devrodrigo._22marketplaceeventos.ticketing.domain;

import org.springframework.util.Assert;

public record SeatId (String id) {
    public SeatId {
        Assert.notNull(id, "id não pode ser null");
    }
}
