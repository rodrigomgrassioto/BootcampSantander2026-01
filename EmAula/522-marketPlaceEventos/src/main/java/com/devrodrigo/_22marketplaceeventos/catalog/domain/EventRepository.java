package com.devrodrigo._22marketplaceeventos.catalog.domain;

import java.util.List;

public interface EventRepository {
    List<Event> findAll();
}
