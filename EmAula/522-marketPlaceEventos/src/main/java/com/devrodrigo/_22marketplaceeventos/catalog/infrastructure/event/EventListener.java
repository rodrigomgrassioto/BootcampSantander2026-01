package com.devrodrigo._22marketplaceeventos.catalog.infrastructure.event;

import com.devrodrigo._22marketplaceeventos.catalog.infrastructure.persistence.entity.Event;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventListener {
    private static final Logger logger = LoggerFactory.getLogger(EventListener.class);

    @PostPersist
    public void onEventCreated(Event event) {
        logger.info("Evento criado via @PostPersist {}", event);
    }

    @PostUpdate
    public void onEventUpdated(Event event) {
        logger.info("Evento criado via @PostUpdate {}", event);
    }

    @PostRemove
    public void onEventRemoved(Event event) {
        logger.info("Evento criado via @PostRemove {}", event);
    }

}
