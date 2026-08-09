package com.devrodrigo.proposal_manager.proposal.infrastructure.persistence.repository;

import com.devrodrigo.proposal_manager.proposal.domain.OwnerId;
import com.devrodrigo.proposal_manager.proposal.domain.Proposal;
import com.devrodrigo.proposal_manager.proposal.domain.ProposalRepository;
import com.devrodrigo.proposal_manager.proposal.infrastructure.persistence.entity.ProposalEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Spliterators.spliterator;

@Repository
public class JpaProposalRepository implements ProposalRepository {
    private final ProposalEntityRepository proposalEntityRepository;

    public JpaProposalRepository(ProposalEntityRepository proposalEntityRepository) {
        this.proposalEntityRepository = proposalEntityRepository;
    }


    @Override
    public List<Proposal> findAll() {
        var iterable = proposalEntityRepository.findAll();
        return StreamSupport
                .stream(iterable.spliterator(), false)
                .map(ProposalEntity::toDomain)
                .toList();
    }

    @Override
    public List<Proposal> findAllByOwnerId(OwnerId ownerId) {
        return proposalEntityRepository.findAllByOwnerId(ownerId.id()).stream().map(ProposalEntity::toDomain).toList();
    }

    @Override
    public Proposal save(Proposal proposal) {
        var entity = ProposalEntity.from(proposal);
        var saved = proposalEntityRepository.save(entity);

        return saved.toDomain();
    }
}
