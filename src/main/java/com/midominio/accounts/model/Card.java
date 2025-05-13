package com.midominio.accounts.model;

public class Card {
	
	private String accountNumber;
	private String cardNumber;
	private Character cardType;
	private String  status;
	private String creationDate;
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Character getCardType() {
		return cardType;
	}
	public void setCardType(Character cardType) {
		this.cardType = cardType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	

}
