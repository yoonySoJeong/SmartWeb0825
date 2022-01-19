package org.day2;
public class Inc {

	public static void main(String[] args) {
		int d=3,a;
		
		a=d++;
		System.out.println("a="+a+",d="+d);
		
		a=++d;
		System.out.println("a="+a+",d="+d);
		
		a=d--;
		System.out.println("a="+a+",d="+d);
		
		a=--d;
		System.out.println("a="+a+",d="+d);
		
	}

}