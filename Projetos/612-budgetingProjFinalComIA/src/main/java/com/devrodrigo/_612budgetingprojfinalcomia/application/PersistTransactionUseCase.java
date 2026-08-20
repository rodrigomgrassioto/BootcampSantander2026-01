package com.devrodrigo._612budgetingprojfinalcomia.application;

import com.devrodrigo._612budgetingprojfinalcomia.application.input.PersistTransactionInput;
import com.devrodrigo._612budgetingprojfinalcomia.application.output.TransactionOutput;
import com.devrodrigo._612budgetingprojfinalcomia.domain.Category;
import com.devrodrigo._612budgetingprojfinalcomia.domain.Transaction;
import com.devrodrigo._612budgetingprojfinalcomia.domain.TransactionRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class PersistTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public PersistTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Tool(name = "persist-transaction", description = "persiste uma nova transação financeira")
    public TransactionOutput execute(PersistTransactionInput input) {
        var transaction = new Transaction(input.description(), input.amount(), input.category());
        var result = transactionRepository.save(transaction);

        return TransactionOutput.from(result);
    }
}
