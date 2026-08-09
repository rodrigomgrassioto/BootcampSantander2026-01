package com.devrodrigo.proposal_manager.proposal.infrastructure.persistence.repository;

import com.devrodrigo.proposal_manager.proposal.infrastructure.persistence.entity.ProposalEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ProposalEntityRepository extends CrudRepository<ProposalEntity, UUID> {
    List<ProposalEntity> findAllByOwnerId(UUID ownerId);
}
