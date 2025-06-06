package com.midominio.accounts.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
@IdClass(AccountId.class)
public class Account {

    @Id
    private String customerNumber;
    @Id
    private String accountNumber;
    private Integer productNumber;
    private String productName;
    private String status;
    private BigDecimal balance;
    private String creationDate;

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
	public Integer getProductNumber() {
        return productNumber;
    }
    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public String getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
	@Override
	public String toString() {
		return "Account [customerNumber=" + customerNumber + ", accountNumber=" + accountNumber + ", productNumber="
		        + productNumber + ", productName=" + productName + ", status=" + status + ", balance=" + balance
		        + ", creationDate=" + creationDate + "]";
	}
}
