package com.devrodrigo._22marketplaceeventos.catalog.application;

import com.devrodrigo._22marketplaceeventos.catalog.domain.Event;
import com.devrodrigo._22marketplaceeventos.catalog.domain.EventMetadataRepository;
import com.devrodrigo._22marketplaceeventos.catalog.domain.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrowseShowcaseUseCase {
    private static final Logger logger = LoggerFactory.getLogger(BrowseShowcaseUseCase.class);

    private final EventRepository eventRepository;
    private final EventMetadataRepository eventMetadataRepository;

    public BrowseShowcaseUseCase(EventRepository eventRepository, EventMetadataRepository eventMetadataRepository) {
        this.eventRepository = eventRepository;
        this.eventMetadataRepository = eventMetadataRepository;
    }

    public List<Event> execute() {
        var events = eventRepository.findAll().stream().map(event -> {
            logger.info("Enriching event: {}", event);
            var metadata = eventMetadataRepository.findByEventId(event.getId());
            event.setMetadata(metadata);

            return event;
        }).toList();
        return events;
    }
}
