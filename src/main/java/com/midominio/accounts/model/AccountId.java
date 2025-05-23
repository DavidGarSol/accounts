package com.midominio.accounts.model;

import java.io.Serializable;
import java.util.Objects;

public class AccountId implements Serializable{

	private String customerNumber;
    private String accountNumber;

	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, customerNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountId other = (AccountId) obj;
		return Objects.equals(accountNumber, other.accountNumber)
		        && Objects.equals(customerNumber, other.customerNumber);
	}
    
    
	

}
