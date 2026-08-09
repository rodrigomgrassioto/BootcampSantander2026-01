package com.devrodrigo.proposal_manager.proposal.application.list;

import com.devrodrigo.proposal_manager.proposal.domain.OwnerId;
import com.devrodrigo.proposal_manager.proposal.domain.Proposal;

import java.util.List;

public interface Strategy {
    List<Proposal> getProposals(OwnerId ownerId);
    AccessScope getScope();
}
