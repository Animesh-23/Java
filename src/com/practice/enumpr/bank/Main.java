package com.practice.enumpr.bank;

public class Main {
	public static void main(String[] args) {
		Person Animesh = new Person();
		Animesh.setBank(new Bank("HDFC"));;
		Animesh.bank.setAccount(new SavingsAccount());
		Animesh.bank.account.deposit(4000);
		Animesh.bank.account.withdraw(489);
		System.out.println(Animesh.bank.viewDetails());
	}
}
