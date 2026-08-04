package com.devrodrigo._22marketplaceeventos.catalog.domain;

import java.util.List;
import java.util.Optional;

public interface EventMetadataRepository {
    Optional<EventMetadata> findByEventId(EventId eventId);
}
