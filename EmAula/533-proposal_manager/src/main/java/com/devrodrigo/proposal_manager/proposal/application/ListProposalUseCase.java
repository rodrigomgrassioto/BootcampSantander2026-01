package com.devrodrigo.proposal_manager.proposal.application;

import com.devrodrigo.proposal_manager.proposal.application.input.CreateProposalInput;
import com.devrodrigo.proposal_manager.proposal.application.list.AccessScope;
import com.devrodrigo.proposal_manager.proposal.application.list.Factory;
import com.devrodrigo.proposal_manager.proposal.application.output.ProposalOutput;
import com.devrodrigo.proposal_manager.proposal.domain.Owner;
import com.devrodrigo.proposal_manager.proposal.domain.OwnerId;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;


import java.util.List;

@Service
public class ListProposalUseCase {
    private final Factory factory;

    public ListProposalUseCase(Factory factory) {
        this.factory = factory;
    }


    public List<ProposalOutput> execute(AccessScope scope, OwnerId ownerId) {
        var proposals = factory.getStrategy(scope).getProposals(ownerId);
        return proposals.stream().map(ProposalOutput::from).toList();
    }
}
