package com.devrodrigo._22marketplaceeventos.registration.infrastructure.persistene;

import com.devrodrigo._22marketplaceeventos.common.infrastructure.event.dto.CustomerCreated;
import com.devrodrigo._22marketplaceeventos.registration.domain.Customer;
import com.devrodrigo._22marketplaceeventos.registration.domain.CustomerId;
import com.devrodrigo._22marketplaceeventos.registration.domain.CustomerRepository;
import com.devrodrigo._22marketplaceeventos.registration.infrastructure.persistene.repository.CustomerEntityRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Repository
public class JpaCustomerRepository implements CustomerRepository {

    private final CustomerEntityRepository customerEntityRepository;
    private final ApplicationEventPublisher publisher;


    public JpaCustomerRepository
            (CustomerEntityRepository customerEntityRepository, ApplicationEventPublisher publisher) {
        this.customerEntityRepository = customerEntityRepository;
        this.publisher = publisher;
    }

    @Override
    public Customer save(Customer customer) {
        var entity = mapper(customer);
        customerEntityRepository.save(entity);
        publisher.publishEvent(new CustomerCreated(customer.getId().toString(), customer.getName()));
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        var iterable =  customerEntityRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(JpaCustomerRepository::mapper).toList();
    }

    private static com.devrodrigo._22marketplaceeventos.registration.infrastructure.persistene.entity.Customer mapper(Customer customer ) {
        var entity = new com.devrodrigo._22marketplaceeventos.registration.infrastructure.persistene.entity.Customer();

        entity.setId(customer.getId().id());
        entity.setEmail(customer.getEmail());

        String[] nameParts = customer.getName().trim().split(" ", 2);

        // Primeira parte firstName
        entity.setFirstName(nameParts[0]);

        // lastName. fica nulo.
        if (nameParts.length > 1) {
            entity.setLastName(nameParts[1]);
        } else {
            entity.setLastName(null);
        }

        return entity;

    }

    private static Customer mapper(com.devrodrigo._22marketplaceeventos.registration.infrastructure.persistene.entity.Customer entity) {
        String fullName = Optional.ofNullable(entity.getLastName())
                .map(lastName -> entity.getFirstName() + ' ' + lastName)
                .orElseGet(entity::getFirstName);

        return new Customer(new CustomerId(entity.getId()), fullName,  entity.getEmail());
    }
}
