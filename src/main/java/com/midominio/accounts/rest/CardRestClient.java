package com.midominio.accounts.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.midominio.accounts.model.Card;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class CardRestClient {
	
	@Autowired
	@LoadBalanced
	private RestTemplate rest;
	
	@CircuitBreaker(name = "cards", fallbackMethod = "responseCardsFallback")
	public List<Card> getCardsByAccountNumber(String accountNumber) {
		ResponseEntity<List> response =
				rest.getForEntity("http://cards/api/cards/{accountNumber}", List.class, accountNumber);
		
		List<Card> cards = response.getBody();
		
		return cards;
	}
	
	public List<Card> responseCardsFallback(Exception ex) {
		return null;
	}

}
