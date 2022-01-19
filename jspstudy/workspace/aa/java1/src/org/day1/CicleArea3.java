package org.day1;

import java.util.Scanner;

public class CicleArea3 {

	public static void main(String[] args) {
		   float area;
		   int w,h;
		   Scanner sc = new Scanner(System.in);
		   System.out.println("밑변 길이 입력?");
		   w=sc.nextInt();
		   System.out.println("높이 입력?");
		   h=sc.nextInt();
		   area=w*h*0.5f;
		   System.out.println("삼형의 넓이는 : " +area);
		   
	}

}
