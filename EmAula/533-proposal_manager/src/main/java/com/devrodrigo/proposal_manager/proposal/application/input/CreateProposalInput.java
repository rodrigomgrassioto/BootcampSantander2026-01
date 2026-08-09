package com.devrodrigo.proposal_manager.proposal.application.input;

import com.devrodrigo.proposal_manager.proposal.domain.Owner;
import com.devrodrigo.proposal_manager.proposal.domain.Proposal;

import java.util.Optional;

public record CreateProposalInput(String title, Optional<String> description) {
    public Proposal toDomain(Owner owner) {
        return new Proposal(title, description, owner);
    }
}
