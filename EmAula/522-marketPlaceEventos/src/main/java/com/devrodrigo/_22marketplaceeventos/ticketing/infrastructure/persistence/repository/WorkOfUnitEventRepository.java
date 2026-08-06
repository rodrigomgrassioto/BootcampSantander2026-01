package com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.repository;

import com.devrodrigo._22marketplaceeventos.ticketing.domain.*;
import com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.entity.SeatLock;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

// work of unit é o padrão para quando se usa dois bancos de dados
@Repository
public class WorkOfUnitEventRepository implements EventRepository {
    private final EventCrudRepository eventCrudRepository;
    private final RedisSeatLockRepository redisSeatLockRepository;

    public WorkOfUnitEventRepository(EventCrudRepository eventCrudRepository, RedisSeatLockRepository redisSeatLockRepository) {
        this.eventCrudRepository = eventCrudRepository;
        this.redisSeatLockRepository = redisSeatLockRepository;
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

    @Override
    public boolean existsSeat(EventId eventId, SeatId seatId) {
        return eventCrudRepository.existsByCorrelationIdAndSectors_Seats_CorrelationId(eventId.id(), seatId.id());
    }

    @Override
    public boolean tryLockSeat(EventId eventId, SeatId seatId, CustomerId customerId) {
        String lockId = eventId.id().toString()+":"+seatId.id();

        if (redisSeatLockRepository.existsById(lockId)) {
            return false;
        }
        var lock = new SeatLock(lockId, customerId.id().toString(), Instant.now());
        redisSeatLockRepository.save(lock);
        return true;
    }
}
