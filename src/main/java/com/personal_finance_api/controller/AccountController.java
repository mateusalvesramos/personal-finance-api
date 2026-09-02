package com.personal_finance_api.controller;

import com.personal_finance_api.dto.AccountRequest;
import com.personal_finance_api.dto.AccountResponse;
import com.personal_finance_api.exception.NotFoundException;
import com.personal_finance_api.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AccountResponse> findAllAccounts() {

        return accountService.findAllAccounts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountResponse findAccountById(@PathVariable("id") Integer id) throws NotFoundException {

        return accountService.findAccountById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@Valid @RequestBody AccountRequest accountRequest) throws NotFoundException{

        accountService.createAccount(accountRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAccount(@Valid @PathVariable("id") Integer id, @RequestBody AccountRequest accountRequest) throws NotFoundException {

        accountService.updateAccount(id, accountRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable("id") Integer id) throws NotFoundException {

        accountService.deleteAccount(id);
    }
}
