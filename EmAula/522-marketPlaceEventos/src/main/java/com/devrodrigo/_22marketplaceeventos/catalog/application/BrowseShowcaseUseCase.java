package com.devrodrigo._22marketplaceeventos.catalog.application;

import com.devrodrigo._22marketplaceeventos.catalog.application.dto.EventOutput;
import com.devrodrigo._22marketplaceeventos.catalog.domain.Event;
import com.devrodrigo._22marketplaceeventos.catalog.domain.EventMetadataRepository;
import com.devrodrigo._22marketplaceeventos.catalog.domain.EventRepository;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class BrowseShowcaseUseCase {
    private static final Logger logger = LoggerFactory.getLogger(BrowseShowcaseUseCase.class);

    private final EventRepository eventRepository;
    private final EventEnricher eventEnricher;

    public BrowseShowcaseUseCase(EventRepository eventRepository, EventMetadataRepository eventMetadataRepository) {
        this.eventRepository = eventRepository;
        this.eventEnricher = new EventEnricher(eventMetadataRepository);
    }

    public List<EventOutput> execute() {
        var futures = eventRepository.findAll().stream().map(eventEnricher::enrich).toList();
        var events = futures.stream()
                .map(CompletableFuture::join)
                .map(EventOutput::from)
                .toList();

        logger.info("{} events enriched", events.size());

        return events;
    }
}
