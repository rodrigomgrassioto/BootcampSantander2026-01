package com.devrodrigo.proposal_manager.proposal.infrastructure.http.response;

import com.devrodrigo.proposal_manager.proposal.application.output.ProposalOutput;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // remove valores null ao gerar JSON
public record ProposalResponse(String id, String title, String description, OwnerResponse owner) {
    public record OwnerResponse(String id, String name){

    }
    public static ProposalResponse from(ProposalOutput output) {
        return new ProposalResponse(
                output.id(),
                output.title(),
                output.description().orElse(null),
                new OwnerResponse(output.ownerId(), output.ownerName())
        );
    }
}
