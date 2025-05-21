package com.midominio.accounts.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.midominio.accounts.model.Card;

@FeignClient(
		name = "${client.cards.name}",
		path = "${client.cards.path}",
		configuration = MyConfigurationClient.class
		)
public interface CardClient {
	
	@GetMapping("/cards/{accountNumber}")
	public List<Card> getCardsByAccountNumber(@PathVariable String accountNumber);

}
