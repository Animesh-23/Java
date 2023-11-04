package com.practice.enumpr.bank;

public class Person {
	Bank bank;
	{
		this.bank = new Bank("BOI");
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
}
