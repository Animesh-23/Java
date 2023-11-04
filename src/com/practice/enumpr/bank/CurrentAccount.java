package com.practice.enumpr.bank;

public class CurrentAccount implements Account {

	private int money = 0;
	@Override
	public int deposit(int money) {
		this.money = this.money + money;
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
		return 0;
	}

	@Override
	public int viewBalance() {
		return this.money;
	}

	@Override
	public String getType() {
		return "Current";
	}


}
