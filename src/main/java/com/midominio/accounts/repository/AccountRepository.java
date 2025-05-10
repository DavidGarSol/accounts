package com.midominio.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midominio.accounts.model.Account;
import com.midominio.accounts.model.AccountId;

public interface AccountRepository extends JpaRepository<Account, AccountId> {

}
