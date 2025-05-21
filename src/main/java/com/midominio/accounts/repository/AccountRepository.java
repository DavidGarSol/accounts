package com.midominio.accounts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midominio.accounts.model.Account;
import com.midominio.accounts.model.AccountId;

public interface AccountRepository extends JpaRepository<Account, AccountId> {

	List<Account> findByAccountNumber(String accountNumber);
	Account findByCustomerNumber(String customerNumber);
}
