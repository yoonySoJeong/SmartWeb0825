package org.day2;
import java.util.Scanner;
public class SwitchTest2 {

	public static void main(String[] args) {
        int su;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수를 입력하세요?");
		su=sc.nextInt();
		
		if (su%3==0) 
			System.out.println("3의 배수 입니다.");
		else 
			System.out.println("3의 배수가 아닙니다.");

	}

}
