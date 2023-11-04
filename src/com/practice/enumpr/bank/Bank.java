package com.practice.enumpr.bank;

public class Bank {
	Account account;
	private String bankName;
	Bank(String bankName){
		this.bankName = bankName;
	}
	{
		this.account = new CurrentAccount();
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String viewDetails() {
		return "Bank name "+this.bankName+", Account type "+this.account.getType()+", balance "+this.account.viewBalance();
	}
}
