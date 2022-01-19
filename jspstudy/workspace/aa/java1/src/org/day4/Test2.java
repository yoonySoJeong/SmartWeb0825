package org.day4;

public class Test2 {

	public static void main(String[] args) {
	string name, job, blood;
	int age;
	public Human (string n, string j, string b, int a) {
		name = n, job = j, blood = b, age = a;
	}
	public void speak () {
		System.out.println("말한다.");
	}
	public void study () {
		System.out.println("공부한다.");
	}
	public static void main(String[] args) {
		Humen h1 = new Humen ("이빛나","의사","A",35);
		System.out.println(h.1name+ " 님의 직업은"+h1.job);
		h1.study(); h1.speak();
		
		Humen h2 = new Humen ("김보람","학생","B",22);
		System.out.println(h.2name+ " 님의 직업은"+h2.job);
		
	}
	
}
