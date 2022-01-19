package org.day1;

import java.util.Scanner;

public class CircleArea2 {

	public static void main(String[] args) {
		   int w,h,area;
		   Scanner sc = new Scanner(System.in);
		   System.out.println("가로길이 입력?");
		   w=sc.nextInt();
		   System.out.println("세로길이 입력?");
		   h=sc.nextInt();
		   area=w*h;
		   System.out.println("사각형의 넓이는 : " +area);
		   
	}

}
