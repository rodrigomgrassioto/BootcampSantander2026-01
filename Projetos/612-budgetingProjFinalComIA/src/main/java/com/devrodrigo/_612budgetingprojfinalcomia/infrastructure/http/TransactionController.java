package com.devrodrigo._612budgetingprojfinalcomia.infrastructure.http;

import com.devrodrigo._612budgetingprojfinalcomia.application.PersistTransactionUseCase;
import com.devrodrigo._612budgetingprojfinalcomia.infrastructure.http.request.TransactionRequest;
import com.devrodrigo._612budgetingprojfinalcomia.infrastructure.http.response.TransactionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final PersistTransactionUseCase persistTransactionUseCase;

    public TransactionController(PersistTransactionUseCase persistTransactionUseCase) {
        this.persistTransactionUseCase = persistTransactionUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse createTransaction(@RequestBody TransactionRequest request) {
        var transaction = persistTransactionUseCase.execute(request.toInput());
        return TransactionResponse.from(transaction);
    }
}
