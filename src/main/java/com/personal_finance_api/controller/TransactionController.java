package com.personal_finance_api.controller;

import com.personal_finance_api.dto.TransactionRequest;
import com.personal_finance_api.dto.TransactionResponse;
import com.personal_finance_api.exception.NotFoundException;
import com.personal_finance_api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionResponse> findAllTransactions() {

        return transactionService.findAllTransactions();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionResponse findTransactionById(@PathVariable("id") Integer id) throws NotFoundException {

        return transactionService.findTransactionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@RequestBody TransactionRequest transactionRequest) throws NotFoundException {

        transactionService.createTransaction(transactionRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTransaction(@PathVariable("id") Integer id, @RequestBody TransactionRequest transactionRequest) throws NotFoundException {

        transactionService.updateTransaction(id, transactionRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransaction(@PathVariable("id") Integer id) throws NotFoundException {

        transactionService.deleteTransaction(id);
    }

}
