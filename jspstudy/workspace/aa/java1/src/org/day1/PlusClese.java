package org.day1;
import java.util.Scanner;
public class PlusClese {

	public static void main(String[] args) {
		int a,b;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫수 입력?");
	    a=sc.nextInt();
		System.out.println("부번째  입력?");
		b=sc.nextInt();
		
		System.out.println(a+"+"+b+"="+(a+b));
		System.out.println(a+"-"+b+"="+(a-b));
		System.out.println(a+"*"+b+"="+a*b);
		System.out.println(a+"/"+b+"="+a/b);
		System.out.println(a+"%"+b+"="+a%b);

	}

}
