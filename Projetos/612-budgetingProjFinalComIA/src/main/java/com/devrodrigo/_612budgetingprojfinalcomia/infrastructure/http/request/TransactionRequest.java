package com.devrodrigo._612budgetingprojfinalcomia.infrastructure.http.request;

import com.devrodrigo._612budgetingprojfinalcomia.application.input.PersistTransactionInput;
import com.devrodrigo._612budgetingprojfinalcomia.domain.Category;

public record TransactionRequest(String  description, Category category, long amount) {
    public PersistTransactionInput toInput() {
        return new PersistTransactionInput(description, amount, category);
    }
}
