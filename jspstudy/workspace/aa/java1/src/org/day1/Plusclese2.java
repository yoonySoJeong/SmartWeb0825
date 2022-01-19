package org.day1;
import java.util.Scanner;
public class Plusclese2 {

	public static void main(String[] args) {
		int a,b;
		double c,d,e,f,g;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫수 입력?");
	    a=sc.nextInt();
		System.out.println("부번째  입력?");
		b=sc.nextInt();
		
		c=a+b;
	    d=a-b;
	    e=a*b;
	    f=a/b;
	    g=a%b;
		
		System.out.println(a+"+"+b+"="+c);
		System.out.println(a+"-"+b+"="+d);
		System.out.println(a+"*"+b+"="+e);
		System.out.println(a+"/"+b+"="+f);
		System.out.println(a+"%"+b+"="+g);

	}

}
