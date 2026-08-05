package com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.repository;

import com.devrodrigo._22marketplaceeventos.ticketing.domain.Customer;
import com.devrodrigo._22marketplaceeventos.ticketing.domain.CustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresCustomerRepository implements CustomerRepository {
    private final CustomerCrudRepository customerCrudRepository;

    public PostgresCustomerRepository(CustomerCrudRepository customerCrudRepository) {
        this.customerCrudRepository = customerCrudRepository;
    }

    @Override
    public void save(Customer customer) {
        var entity = new com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.entity.Customer(
                customer.getId(),
                customer.getCurrelationId().id(),
                customer.getName()
        );
        customerCrudRepository.save(entity);
    }
}
