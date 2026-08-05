package com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.repository;

import com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RepositoryRestResource(exported = false, path = "_customer") // não expõe a API
public interface CustomerCrudRepository extends CrudRepository<Customer, UUID> {
}
