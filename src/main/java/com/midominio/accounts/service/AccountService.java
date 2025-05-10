package com.midominio.accounts.service;

import java.util.List;

import com.midominio.accounts.model.Account;
import com.midominio.accounts.model.AccountId;

public interface AccountService {

    List<Account> getAccounts();
    Account getAccount(AccountId accountId);

}
