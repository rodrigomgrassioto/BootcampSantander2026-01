package com.devrodrigo._22marketplaceeventos.registration.infrastructure.persistene.repository;

//import com.devrodrigo._22marketplaceeventos.registration.domain.Customer;
import com.devrodrigo._22marketplaceeventos.registration.infrastructure.persistene.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface CustomerEntityRepository extends
        PagingAndSortingRepository<Customer, UUID>,  CrudRepository<Customer, UUID> {
    //cria nova consulta
    List<Customer> findByFirstNameStartingWithIgnoreCase(@Param("firstName") String firstName);


    // Bloquear delete por ID
    @Override
    @RestResource(exported = false)
    void deleteById(UUID id);
}
