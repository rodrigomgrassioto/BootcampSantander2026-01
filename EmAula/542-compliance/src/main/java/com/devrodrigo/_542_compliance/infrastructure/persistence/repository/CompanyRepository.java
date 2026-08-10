package com.devrodrigo._542_compliance.infrastructure.persistence.repository;

//import com.devrodrigo._542_compliance.domain.Company;
import com.devrodrigo._542_compliance.infrastructure.persistence.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "companies") // expõe para API
public interface CompanyRepository extends CrudRepository<CompanyEntity, UUID> {
}
