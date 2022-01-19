package org.day1;
import java.util.Scanner;
public class CircleArea {
	public static void main(String[] args) {
	   double a;
	   int r;
	   Scanner sc = new Scanner(System.in);
       System.out.println("반지름을 입력하세요?");
	   r=sc.nextInt();
	   a=r*r*3.14;
	   System.out.println(a);
     }
}