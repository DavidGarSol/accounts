package com.midominio.accounts.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midominio.accounts.client.CardClient;
import com.midominio.accounts.model.Account;
import com.midominio.accounts.model.AccountId;
import com.midominio.accounts.model.AccountResponse;
import com.midominio.accounts.model.Card;
import com.midominio.accounts.repository.AccountRepository;
import com.midominio.accounts.rest.CardRestClient;
import com.midominio.accounts.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repo;
    
    @Autowired
    private CardClient feign;
    
    @Autowired
    private CardRestClient rest;

    @Override
    public List<AccountResponse> getAccounts() {
        return repo.findAll().stream().map(c -> {
        	AccountResponse r = new AccountResponse();
        	r.setAccountNumber(c.getAccountNumber());
        	r.setBalance(c.getBalance());
        	r.setCustomerNumber(c.getCustomerNumber());
        	r.setProductName(c.getProductName());
        	r.setProductNumber(c.getProductNumber());
        	
        	List<Card> crds = feign.getCardsByAccountNumber(c.getAccountNumber());
        	r.setCards(crds);
        	
        	return r;
        }).toList();
    }

    @Override
    public Account getAccount(AccountId accountId) {
        return repo.findById(accountId).orElse(null);
    }

	@Override
	public List<AccountResponse> getByCustomerNumber(String customerNumber) {
		return repo.findByAccountNumber(customerNumber)
				.stream()
//				.filter(c -> c.getStatus().equals("ACT"))
				.map(c -> {
					AccountResponse r = new AccountResponse();
					r.setProductNumber(c.getProductNumber());
					r.setBalance(c.getBalance());
					r.setAccountNumber(c.getAccountNumber());
					r.setCustomerNumber(c.getCustomerNumber());
					r.setProductName(c.getProductName());
					r.setProductNumber(c.getProductNumber());
					
					List<Card> crds = rest.getCardsByAccountNumber(c.getAccountNumber());
					r.setCards(crds);
					
					return r;
				})
				.toList();
	}

}
