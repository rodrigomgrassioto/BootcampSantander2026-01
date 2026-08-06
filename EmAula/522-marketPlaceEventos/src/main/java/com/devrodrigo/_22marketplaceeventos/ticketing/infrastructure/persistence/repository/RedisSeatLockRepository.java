package com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.repository;

import com.devrodrigo._22marketplaceeventos.ticketing.infrastructure.persistence.entity.SeatLock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface RedisSeatLockRepository extends CrudRepository<SeatLock, String> {
    Optional<SeatLock> findByCustomerId(String customerId);
}
