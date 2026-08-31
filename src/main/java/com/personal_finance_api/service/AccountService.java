package com.personal_finance_api.service;

import com.personal_finance_api.database.model.AccountEntity;
import com.personal_finance_api.database.model.UserEntity;
import com.personal_finance_api.database.repository.IAccountRepository;
import com.personal_finance_api.database.repository.IUserRepository;
import com.personal_finance_api.dto.AccountRequest;
import com.personal_finance_api.dto.AccountResponse;
import com.personal_finance_api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.accept.NotAcceptableApiVersionException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final IAccountRepository accountRepository;
    private final IUserRepository userRepository;

    public List<AccountResponse> findAllAccounts() {

         return accountRepository.findAll()
                .stream()
                .map(account -> new AccountResponse(account.getId(), account.getName(), account.getType(), account.getBalance(), account.getUser().getId()))
                .toList();

    }

    public AccountResponse findAccountById(Integer id) throws NotFoundException {

        AccountEntity account = accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        return AccountResponse.builder()
                .id(account.getId())
                .name(account.getName())
                .type(account.getType())
                .balance(account.getBalance())
                .user_id(account.getUser().getId())
                .build();
    }

    public void createAccount(AccountRequest newAccount) throws NotFoundException {

        UserEntity user = userRepository.findById(newAccount.getUser_id())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        accountRepository.save(AccountEntity.builder()
                .name(newAccount.getName())
                .type(newAccount.getType())
                .balance(newAccount.getBalance())
                .user(user)
                .build());

    }

    public void updateAccount(Integer id, AccountRequest updatedAccount) throws NotFoundException {

        AccountEntity account = accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Conta não encontrada"));

        UserEntity user = userRepository.findById(updatedAccount.getUser_id())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        account.setName(updatedAccount.getName());
        account.setType(updatedAccount.getType());
        account.setBalance(updatedAccount.getBalance());
        account.setUser(user);

        accountRepository.save(account);
    }

    public void deleteAccount(Integer id) throws NotFoundException {

        AccountEntity account = accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Conta não encontrada"));

        accountRepository.delete(account);
    }

}
