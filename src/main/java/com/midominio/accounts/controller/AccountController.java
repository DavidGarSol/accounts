package com.midominio.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midominio.accounts.model.Account;
import com.midominio.accounts.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return service.getAccounts();
    }

}
