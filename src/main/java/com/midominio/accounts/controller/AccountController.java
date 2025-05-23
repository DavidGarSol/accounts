package com.midominio.accounts.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midominio.accounts.exception.UnauthorizedException;
import com.midominio.accounts.model.Account;
import com.midominio.accounts.model.AccountResponse;
import com.midominio.accounts.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class AccountController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService service;
    
    @GetMapping("/accounts")
    public List<AccountResponse> getByAccountNumber(
    		@RequestHeader(name = "Authorization") String authorization) {
    	LOG.debug("Accounts Request");
    	LOG.debug("Authorization toke: " + authorization);
    	return service.getByCustomerNumber(authorization);
    }

}
