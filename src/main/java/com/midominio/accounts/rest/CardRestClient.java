package com.midominio.accounts.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.midominio.accounts.model.Card;

@Component
public class CardRestClient {
	
	@Autowired
	@LoadBalanced
	private RestTemplate rest;
	
	public List<Card> getCardsByAccountNumber(String accountNumber) {
		ResponseEntity<List> response =
				rest.getForEntity("http://cards/api/cards/{accountNumber}", List.class, accountNumber);
		
		List<Card> cards = response.getBody();
		
		return cards;
	}

}
