package com.devrodrigo._542_compliance.infrastructure.persistence.repository;

import com.devrodrigo._542_compliance.domain.Company;
import com.devrodrigo._542_compliance.domain.CompanyRepository;
import com.devrodrigo._542_compliance.infrastructure.persistence.entity.CompanyEntity;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCompanyRepository implements CompanyRepository {
    private final CompanyEntityRepository repository;

    public InMemoryCompanyRepository(CompanyEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Company company){
        var entity = CompanyEntity.from(company);
        repository.save(entity);
    }

}
