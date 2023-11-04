package com.practice.enumpr;

public enum Months {
	JANUARY(31),FEBRUARY(28);
	
	private int days;
	Months(int days){
		this.days = days;
	}
	public static void main(String[] args) {
		Months first = Months.JANUARY;
		System.out.println(first.days);
	}
}
