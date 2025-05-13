package com.midominio.accounts.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.midominio.accounts.model.Card;

@FeignClient(name = "cards", url = "localhost:8083")
public interface CardClient {
	
	@GetMapping("/api/cards/{accountNumber}")
	public List<Card> getCardsByAccountNumber(@PathVariable String accountNumber);

}
