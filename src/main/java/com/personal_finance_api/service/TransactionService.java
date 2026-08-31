package com.personal_finance_api.service;

import com.personal_finance_api.database.model.AccountEntity;
import com.personal_finance_api.database.model.TransactionEntity;
import com.personal_finance_api.database.repository.IAccountRepository;
import com.personal_finance_api.database.repository.ITransactionRepository;
import com.personal_finance_api.dto.TransactionRequest;
import com.personal_finance_api.dto.TransactionResponse;
import com.personal_finance_api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final ITransactionRepository transactionRepository;
    private final IAccountRepository accountRepository;

    public List<TransactionResponse> findAllTransactions() {

        List<TransactionResponse> transactions = new ArrayList<>();
        transactions = transactionRepository.findAll()
                .stream()
                .map(transaction -> new TransactionResponse(transaction.getId(), transaction.getDescription(), transaction.getAmount(), transaction.getDate(), transaction.getType(), transaction.getAccount().getId()))
                .toList();

        return transactions;
    }

    public TransactionResponse findTransactionById(Integer id) throws NotFoundException{

        TransactionEntity transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Transação não encontrada"));

        return TransactionResponse.builder()
                .id(transaction.getId())
                .description(transaction.getDescription())
                .amount(transaction.getAmount())
                .date(transaction.getDate())
                .type(transaction.getType())
                .account_id(transaction.getAccount().getId())
                .build();
    }

    @Transactional
    public void createTransaction(TransactionRequest transactionRequest) throws NotFoundException {

        AccountEntity account = accountRepository.findById(transactionRequest.getAccount_id())
                .orElseThrow(() -> new NotFoundException("Conta não encontrada"));

        account.setBalance(account.getBalance().subtract(transactionRequest.getAmount()));

        accountRepository.save(account);

        transactionRepository.save(TransactionEntity.builder()
                .description(transactionRequest.getDescription())
                .amount(transactionRequest.getAmount())
                .date(transactionRequest.getDate())
                .type(transactionRequest.getType())
                .account(account)
                .build());
    }

    @Transactional
    public void updateTransaction(Integer id, TransactionRequest updatedTransaction) throws NotFoundException {

        TransactionEntity transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Transação não encontrada"));

        // AccountEntity account = transaction.getAccount();

        AccountEntity account = accountRepository.findById(updatedTransaction.getAccount_id())
                        .orElseThrow(() -> new NotFoundException("Conta não encontrada"));

        account.setBalance(account.getBalance().add(transaction.getAmount()));
        account.setBalance(account.getBalance().subtract(updatedTransaction.getAmount()));

        accountRepository.save(account);

        transaction.setDescription(updatedTransaction.getDescription());
        transaction.setAmount(updatedTransaction.getAmount());
        transaction.setDate(updatedTransaction.getDate());
        transaction.setType(updatedTransaction.getType());
        transaction.setAccount(account);

        transactionRepository.save(transaction);
    }

    @Transactional
    public void deleteTransaction(Integer id) throws NotFoundException {

        TransactionEntity transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Transação não encontrada"));

        AccountEntity account = transaction.getAccount();

        account.setBalance(account.getBalance().add(transaction.getAmount()));

        accountRepository.save(account);

        transactionRepository.delete(transaction);
    }
}
