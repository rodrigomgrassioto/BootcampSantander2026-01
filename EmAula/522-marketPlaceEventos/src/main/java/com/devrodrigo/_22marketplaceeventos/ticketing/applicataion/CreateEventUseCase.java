package com.devrodrigo._22marketplaceeventos.ticketing.applicataion;

import com.devrodrigo._22marketplaceeventos.common.infrastructure.event.dto.EventUpdated;
import com.devrodrigo._22marketplaceeventos.ticketing.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CreateEventUseCase {
    private final EventRepository eventRepository;

    public CreateEventUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void execute(EventUpdated event){
        Map<Sector, List<Seat>> seats = event.sectors().stream()
                .collect(Collectors.toMap(
                        sector -> new Sector(sector.id(), sector.price()),
                        sector -> sector.seats().stream()
                                .map(seatDto -> new Seat(seatDto.number()))
                                .toList()
                ));
        eventRepository.save(new Event(event.id(), seats));
    }
}
