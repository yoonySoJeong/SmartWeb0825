package org.day2;
import java.util.Scanner;
public class IfDemo {

	public static void main(String[] args) {
        int a;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수를 입력하세요? (0~500)");
		a=sc.nextInt();

		if (a>=2500) System.out.println("큰수");
		else System.out.println("작은수");
			
		
	}

}
