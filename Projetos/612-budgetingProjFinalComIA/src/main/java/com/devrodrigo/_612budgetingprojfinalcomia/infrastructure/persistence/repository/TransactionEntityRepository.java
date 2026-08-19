package com.devrodrigo._612budgetingprojfinalcomia.infrastructure.persistence.repository;

import com.devrodrigo._612budgetingprojfinalcomia.domain.Category;
import com.devrodrigo._612budgetingprojfinalcomia.infrastructure.persistence.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionEntityRepository extends CrudRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findAllByCategory(Category category);
}
