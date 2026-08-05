package com.devrodrigo._22marketplaceeventos.ticketing.domain;

import org.springframework.util.Assert;
import java.util.UUID;

public record SectorId (String id){
    public SectorId{
        Assert.notNull(id, "id não pode ser null");
    }
}
