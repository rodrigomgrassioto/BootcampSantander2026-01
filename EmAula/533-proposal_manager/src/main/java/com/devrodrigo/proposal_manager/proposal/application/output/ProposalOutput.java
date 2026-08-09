package com.devrodrigo.proposal_manager.proposal.application.output;

import com.devrodrigo.proposal_manager.proposal.application.input.CreateProposalInput;
import com.devrodrigo.proposal_manager.proposal.domain.Proposal;

import java.util.Optional;

public record ProposalOutput(String id, String title, Optional<String> description, String ownerId, String ownerName) {
    public static ProposalOutput from(Proposal proposal) {
        return new ProposalOutput(proposal.getId().toString(),
                proposal.getTitle(),
                proposal.getDescription(),
                proposal.getOwner().id().toString(),
                proposal.getOwner().name());
    }
}
