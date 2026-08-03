package com.devrodrigo._22marketplaceeventos.registration.infrastructure.event;

import com.devrodrigo._22marketplaceeventos.registration.domain.CustomerRepository;
import com.devrodrigo._22marketplaceeventos.registration.infrastructure.persistene.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;


@Component
@RepositoryEventHandler
public class CustomerEventHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomerEventHandler.class);

    @HandleAfterCreate
    public void handleAfterCreate(Customer customer) {
        logger.warn("Após Criação do customer");
    }

    @HandleAfterSave
    public void handleAfterSave(Customer customer) {
        logger.warn("Após atualização do customer");
    }

    @HandleAfterDelete
    public void handleAfterDelete(Customer customer) {
        logger.warn("Customer deletado");

    }

}
