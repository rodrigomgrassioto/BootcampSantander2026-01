package com.devrodrigo._22marketplaceeventos.catalog.infrastructure.persistence.repository;

import com.devrodrigo._22marketplaceeventos.catalog.infrastructure.persistence.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface EventEntityRepository extends CrudRepository<Event, UUID> {
}
