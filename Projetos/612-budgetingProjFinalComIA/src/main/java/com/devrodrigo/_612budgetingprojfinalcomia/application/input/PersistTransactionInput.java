package com.devrodrigo._612budgetingprojfinalcomia.application.input;

import com.devrodrigo._612budgetingprojfinalcomia.domain.Category;
import org.springframework.ai.tool.annotation.ToolParam;

public record PersistTransactionInput(
        @ToolParam(description = "Descrição do gasto") String description,
        @ToolParam(description = "valor do gasto em centavos") long amount,
        @ToolParam(description = "categoria de uma transação") Category category) {
}
