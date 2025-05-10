package com.midominio.accounts.model;

import java.io.Serializable;

public class AccountId implements Serializable{
    private String customerNumber;
    private String customerAccount;
    public String getCustomerNumber() {
        return customerNumber;
    }
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
    public String getCustomerAccount() {
        return customerAccount;
    }
    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerNumber == null) ? 0 : customerNumber.hashCode());
        result = prime * result + ((customerAccount == null) ? 0 : customerAccount.hashCode());
        return result;
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
        if (customerNumber == null) {
            if (other.customerNumber != null)
                return false;
        } else if (!customerNumber.equals(other.customerNumber))
            return false;
        if (customerAccount == null) {
            if (other.customerAccount != null)
                return false;
        } else if (!customerAccount.equals(other.customerAccount))
            return false;
        return true;
    }


}
