package org.day1;
import java.util.Scanner;
public class Increase2 {

	public static void main(String[] args) {
		int a,b;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("a 입력?");
	    a=sc.nextInt();

		System.out.println("a="+(++a));
		System.out.println("a="+(a++));
		System.out.println("a="+(a));
	}

}
