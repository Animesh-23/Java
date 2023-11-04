package com.practice.enumpr.bank;

public interface Account {
	int deposit(int money);
	int withdraw(int money);
	int calulateInterest();
	int viewBalance();
	String getType();
}
