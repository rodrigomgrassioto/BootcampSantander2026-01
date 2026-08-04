package com.devrodrigo._22marketplaceeventos.catalog.domain;

import java.time.Instant;
import java.util.Optional;

public class Event {
    private EventId id;
    private String title;
    private Instant data;
    private Optional<EventMetadata> metadata;

    public Event(EventId eventID, String title, Instant data, Optional<EventMetadata> metadata) {
        this.id = eventID;
        this.title = title;
        this.data = data;
        this.metadata = metadata;
    }

    public EventId getId() {
        return id;
    }

    public void setId(EventId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Optional<EventMetadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(Optional<EventMetadata> metadata) {
        this.metadata = metadata;
    }
}
