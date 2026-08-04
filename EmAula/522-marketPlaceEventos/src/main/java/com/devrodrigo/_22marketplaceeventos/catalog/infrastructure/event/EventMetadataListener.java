package com.devrodrigo._22marketplaceeventos.catalog.infrastructure.event;

import com.devrodrigo._22marketplaceeventos.catalog.infrastructure.persistence.entity.EventMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class EventMetadataListener extends AbstractMongoEventListener<EventMetadata> {
    private final Logger logger = LoggerFactory.getLogger(EventMetadataListener.class);

    @Override
    public void onAfterSave(AfterSaveEvent<EventMetadata> event) {
        logger.info("EventoMetadata salvo via onAfterSave {}", event.toString());
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<EventMetadata> event) {
        logger.info("EventoMetadata excluído via onAfterDelete {}", event.toString());
    }
}
