package com.devrodrigo._612budgetingprojfinalcomia.application;

import com.devrodrigo._612budgetingprojfinalcomia.application.output.TransactionOutput;
import com.devrodrigo._612budgetingprojfinalcomia.domain.Category;
import com.devrodrigo._612budgetingprojfinalcomia.domain.TransactionRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListTransactionsByCategoryUseCase {
    private final TransactionRepository transactionRepository;

    public ListTransactionsByCategoryUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Tool(name = "list-transaction-by-category", description = "lista transações financeiras por categoria")
    public List<TransactionOutput> execute(@ToolParam(description = "Categoria de uma transação") Category category) {
        return transactionRepository.findAllByCategory(category)
                .stream()
                .map(TransactionOutput::from)
                .toList();
    }
}
