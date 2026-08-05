package com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.repository;

import com.devrodrigo._22marketplaceeventos.ticketing.domain.Event;
import com.devrodrigo._22marketplaceeventos.ticketing.domain.EventRepository;
import com.devrodrigo._22marketplaceeventos.ticketing.domain.Seat;
import com.devrodrigo._22marketplaceeventos.ticketing.domain.Sector;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostgresEventRepository implements EventRepository {
    private final EventCrudRepository eventCrudRepository;

    public PostgresEventRepository(EventCrudRepository eventCrudRepository) {
        this.eventCrudRepository = eventCrudRepository;
    }

    @Override
    public void save(Event event){
        var sectots = event.getSeats().entrySet().stream()
                .map(entry -> {
                    Sector domainSector = entry.getKey();
                    List<Seat> domainSeats = entry.getValue();

                    var seats = domainSeats.stream()
                            .map(s -> new com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.entity.Seat(
                                    s.getId(),
                                    s.getCorrelationId().id()
                            ))
                            .toList();
                    return new com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.entity.Sector(
                            domainSector.getId(),
                            domainSector.getCorelationId().id(),
                            domainSector.getPrice(),
                            seats
                    );
                }).toList();
        var entity = new com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.entity.Event(
                event.getId(),
                event.getCorelationId().id(),
                sectots);

        eventCrudRepository.save(entity);
    }
}
