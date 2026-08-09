package com.devrodrigo.proposal_manager.proposal.application;

import com.devrodrigo.proposal_manager.proposal.application.input.CreateProposalInput;
import com.devrodrigo.proposal_manager.proposal.application.output.ProposalOutput;
import com.devrodrigo.proposal_manager.proposal.domain.Owner;
import com.devrodrigo.proposal_manager.proposal.domain.ProposalRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProposalUseCase {
    private final ProposalRepository proposalRepository;

    public CreateProposalUseCase(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    public ProposalOutput execute(CreateProposalInput input, Owner owner) {
        var proposal = input.toDomain(owner);
        var saved = proposalRepository.save(proposal);
        return ProposalOutput.from(saved);
    }
}
