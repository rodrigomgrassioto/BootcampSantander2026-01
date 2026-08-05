package com.devrodrigo._22marketplaceeventos.ticketing.applicataion;

import com.devrodrigo._22marketplaceeventos.common.infrastructure.event.dto.CustomerCreated;
import com.devrodrigo._22marketplaceeventos.ticketing.domain.Customer;
import com.devrodrigo._22marketplaceeventos.ticketing.domain.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCase {
    private final CustomerRepository customerRepository;

    public CreateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(CustomerCreated event){
        var customer = new Customer(event.id(),  event.name());
        customerRepository.save(customer);
    }
}
