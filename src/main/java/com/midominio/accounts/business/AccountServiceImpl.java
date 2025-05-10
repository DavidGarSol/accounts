package com.midominio.accounts.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midominio.accounts.model.Account;
import com.midominio.accounts.model.AccountId;
import com.midominio.accounts.repository.AccountRepository;
import com.midominio.accounts.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository repo;

    @Override
    public List<Account> getAccounts() {
        return repo.findAll();
    }

    @Override
    public Account getAccount(AccountId accountId) {
        return repo.findById(accountId).orElse(null);
    }

}
