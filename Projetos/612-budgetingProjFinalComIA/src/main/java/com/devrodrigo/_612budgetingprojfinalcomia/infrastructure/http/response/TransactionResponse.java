package com.devrodrigo._612budgetingprojfinalcomia.infrastructure.http.response;

import com.devrodrigo._612budgetingprojfinalcomia.application.output.TransactionOutput;

public record TransactionResponse(String id, String category, String description, double amount) {
    public static TransactionResponse from(TransactionOutput output) {
        return new TransactionResponse(output.id(), output.category(), output.description(),output.value());
    }
}
