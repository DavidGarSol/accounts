package com.midominio.accounts.controller;

import java.util.List;
import java.util.Objects;

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

    @Autowired
    private AccountService service;
    
    @Autowired
    @Qualifier("redisCacheTest")
    private RedisTemplate<String, String> redis;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return service.getAccounts();
    }
    
    @GetMapping("/accounts/{accountNumber}")
    public List<AccountResponse> getByAccountNumber(
    		@RequestHeader(name = "Authorization") String authorization,
    		@PathVariable String accountNumber) throws Exception {
    	
    	System.out.print("Authorization" + authorization);
    	
    	String auth = redis.opsForValue().get(authorization);
    	
    	System.out.print("redis response" + auth);
    	
    	if (Objects.isNull(auth)) throw new UnauthorizedException("NO SESSION");
    	
    	return service.getByCustomerNumber(accountNumber);
    }

}
