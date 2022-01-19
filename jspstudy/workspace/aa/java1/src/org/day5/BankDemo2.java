package org.day5;

public class BankDemo2 {

	public static void main(String[] args) {
		Bank b1 = new Bank();
		b1.setMoney(20000);
		System.out.println("통장자고 >>" + b1.getMoney());
		b1.Fine(13000);
		System.out.println("통장자고 >>" + b1.getMoney());
	}

}
