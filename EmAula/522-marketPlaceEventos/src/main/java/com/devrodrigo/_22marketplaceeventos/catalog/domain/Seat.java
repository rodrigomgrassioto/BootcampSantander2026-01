package com.devrodrigo._22marketplaceeventos.catalog.domain;

import java.math.BigDecimal;

public class Seat {
    private SeatId id;
    private SectorId sectorId;

    public Seat(SeatId id, SectorId sectorId) {
        this.id = id;
        this.sectorId = sectorId;
    }

    public SeatId getId() {
        return id;
    }

    public void setId(SeatId id) {
        this.id = id;
    }

    public SectorId getSectorId() {
        return sectorId;
    }

    public void setSectorId(SectorId sectorId) {
        this.sectorId = sectorId;
    }
}
