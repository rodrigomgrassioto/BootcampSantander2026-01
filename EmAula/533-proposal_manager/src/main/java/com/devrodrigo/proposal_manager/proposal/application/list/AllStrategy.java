package com.devrodrigo.proposal_manager.proposal.application.list;

import com.devrodrigo.proposal_manager.proposal.domain.OwnerId;
import com.devrodrigo.proposal_manager.proposal.domain.Proposal;
import com.devrodrigo.proposal_manager.proposal.domain.ProposalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllStrategy implements Strategy {
    private final ProposalRepository proposalRepository;

    public AllStrategy(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    @Override
    public List<Proposal> getProposals(OwnerId ownerId) {
        return proposalRepository.findAll();
    }

    @Override
    public AccessScope getScope() {
        return AccessScope.ALL;
    }
}
