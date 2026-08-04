package com.devrodrigo._22marketplaceeventos.catalog.infrastructure.persistence.repository;

import com.devrodrigo._22marketplaceeventos.catalog.domain.Event;
import com.devrodrigo._22marketplaceeventos.catalog.domain.EventId;
import com.devrodrigo._22marketplaceeventos.catalog.domain.EventRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Repository
public class JpaEventRepository implements EventRepository {
    private final EventEntityRepository eventEntityRepository;

    public JpaEventRepository(EventEntityRepository eventEntityRepository) {
        this.eventEntityRepository = eventEntityRepository;
    }

    @Override
    public List<Event> findAll() {
        var iterable = eventEntityRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(JpaEventRepository::mapper).toList();
    }

    private static Event mapper
            (com.devrodrigo._22marketplaceeventos.catalog.infrastructure.persistence.entity.Event event) {
        return new Event(new EventId(event.getId()), event.getTitle(), event.getDate(), Optional.empty());
    }
}
