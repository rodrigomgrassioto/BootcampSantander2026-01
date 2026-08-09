package com.devrodrigo.proposal_manager.proposal.infrastructure.http.request;

import com.devrodrigo.proposal_manager.proposal.application.input.CreateProposalInput;

import java.util.Optional;

public record CreateProposalRequest(String title, Optional<String> description) {
    // converte para o padrão input
    public CreateProposalInput toInput() {
        return new CreateProposalInput(title, description);
    }
}
