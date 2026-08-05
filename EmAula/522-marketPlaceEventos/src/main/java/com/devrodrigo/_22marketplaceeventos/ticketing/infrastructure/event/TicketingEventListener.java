package com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.event;

import com.devrodrigo._22marketplaceeventos.common.infrastructure.event.dto.CustomerCreated;
import com.devrodrigo._22marketplaceeventos.common.infrastructure.event.dto.EventUpdated;
import com.devrodrigo._22marketplaceeventos.ticketing.applicataion.CreateCustomerUseCase;
import com.devrodrigo._22marketplaceeventos.ticketing.applicataion.CreateEventUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TicketingEventListener {
    private static final Logger logger = LoggerFactory.getLogger(TicketingEventListener.class);

    private final CreateCustomerUseCase createCustomerUseCase;
    private final CreateEventUseCase createEventUseCase;

    public TicketingEventListener(CreateCustomerUseCase createCustomerUseCase, CreateEventUseCase createEventUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.createEventUseCase = createEventUseCase;
    }

    @EventListener
    @Async
    public void handle(CustomerCreated event) {
        logger.info("CustomerCreated criado com sucesso {}", event);
        createCustomerUseCase.execute(event);
    }

    @EventListener
    @Async
    public void handle(EventUpdated event) {
        logger.info("EventUpdated criado com sucesso {}", event);
        createEventUseCase.execute(event);
    }

}
