package model.entities;

import model.exceptions.AccountException;

public class Account {
	
	private Integer numberAccount;
	private String holderAccount;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}
	
	public Account(Integer numberAccount, String holderAccount, Double balance, Double withdrawLimit) {
		this.numberAccount = numberAccount;
		this.holderAccount = holderAccount;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public String getHolderAccount() {
		return holderAccount;
	}

	public void setHolderAccount(String holderAccount) {
		this.holderAccount = holderAccount;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumberAccount() {
		return numberAccount;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) {
		validateWithdraw(amount);
		balance -= amount;
	}
	
	public void validateWithdraw(double amount) {
		if (amount > getBalance()) {
			throw new AccountException("Not enough balance");
		}
		if (amount > getWithdrawLimit()) {
			throw new AccountException("The amount exceeds withdraw limit");
		}
	}
}
