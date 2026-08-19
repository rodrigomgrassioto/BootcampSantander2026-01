package com.devrodrigo._612budgetingprojfinalcomia.application.input;

import com.devrodrigo._612budgetingprojfinalcomia.domain.Category;

public record PersistTransactionInput(String description, long amount, Category category) {
}
