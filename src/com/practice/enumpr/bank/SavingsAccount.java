package com.practice.enumpr.bank;

public class SavingsAccount implements Account{
	
	private int money = 0;
	private double interest;
	@Override
	public int deposit(int money) {
		this.money = this.money + money;
		this.interest = money * (0.04);
		return this.money;
	}

	@Override
	public int withdraw(int money) {
		if(this.money < money) {
			return -1;
		}
		this.money = this.money - money;
		return this.money;
	}

	@Override
	public int calulateInterest() {
		return (int)this.interest;
	}

	@Override
	public int viewBalance() {
		return this.money;
	}

	@Override
	public String getType() {
		return "Savings";
	}

}
