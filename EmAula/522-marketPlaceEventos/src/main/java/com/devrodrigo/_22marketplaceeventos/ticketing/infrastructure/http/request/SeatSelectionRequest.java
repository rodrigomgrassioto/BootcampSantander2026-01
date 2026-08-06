package com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.http.request;

import com.devrodrigo._22marketplaceeventos.ticketing.domain.SeatId;

public record SeatSelectionRequest (String id) {
    public SeatId toInput() {
        return new SeatId(id);
    }
}
