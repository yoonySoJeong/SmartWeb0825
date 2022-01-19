package org.day2;

import java.util.Scanner;

public class Inc2 {

	public static void main(String[] args) {
		int d,a;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("d 입력?");
	    d=sc.nextInt();
		
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