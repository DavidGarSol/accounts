package com.midominio.accounts.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.midominio.accounts.session.SessionManagment;

@Service
public class AccountServiceImpl implements AccountService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository repo;
    
    @Autowired
    private CardClient feign;
    
    @Autowired
    private CardRestClient rest;
    
    @Autowired
    private SessionManagment session;

	@Override
	public List<AccountResponse> getByCustomerNumber(String token) {
		
		String customerNumber = session.getValueByKey(token);
		LOG.debug("Customer: " + customerNumber);
		
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
