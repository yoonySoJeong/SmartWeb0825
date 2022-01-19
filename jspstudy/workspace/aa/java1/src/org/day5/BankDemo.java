package org.day5;
class Bank{
	private int money=0; //데이터 무결성이 깨진다. 
	void setMoney(int m) {
		money=m;
	}
	int getMoney() {
		return money;
	}
	void Save(int m) {
		money+=m;
	}
	void Fine(int m) {
		money-=m;
	}
}
public class BankDemo {
	public static void main(String[] args) {
		Bank woori = new Bank();
		woori.setMoney(10000);
		System.out.println("통장잔고 >>" + woori.getMoney());
		woori.Save(20000);
		System.out.println("통장잔고 >>" + woori.getMoney());

	}

}
