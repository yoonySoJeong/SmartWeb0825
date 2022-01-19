package org.day1;
import java.util.Scanner;
public class Bitwise2 {

	public static void main(String[] args) {
		int a,b,i,j;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("a 입력?");
	    a=sc.nextInt();
		System.out.println("b  입력?");
		b=sc.nextInt();
		
		i=a<<2;
		j=b>>2;
		
		System.out.println("2<<2bit=" +i);
		System.out.println("5<<2bit=" +j);
		

	}

}
