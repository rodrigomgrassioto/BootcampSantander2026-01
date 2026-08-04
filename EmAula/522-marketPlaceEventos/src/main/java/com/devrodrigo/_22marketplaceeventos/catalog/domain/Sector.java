package com.devrodrigo._22marketplaceeventos.catalog.domain;

import java.math.BigDecimal;

public class Sector {
    private SectorId id;
    private BigDecimal price;

    public Sector(SectorId id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public SectorId getId() {
        return id;
    }

    public void setId(SectorId id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
