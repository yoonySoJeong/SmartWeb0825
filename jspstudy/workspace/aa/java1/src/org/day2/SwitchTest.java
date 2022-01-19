package org.day2;
import java.util.Scanner;
public class SwitchTest {

	public static void main(String[] args) {
		int su;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수를 입력하세요?");
		su=sc.nextInt();
		if (su%2==0) 
			System.out.println("짝수");
		else 
			System.out.println("홀수");
		
		
		
		/* int a,b;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("수를 입력하세요?");
			a=sc.nextInt();
			b=a%2;
			
			if (b==0) System.out.println("짝수");
			else System.out.println("홀수"); */

	}

}
