package org.day3;
import java.util.Scanner;
public class Test8 {

	public static void main(String[] args) {
	    String[] name = new String[5];  // string 안
		int i; // 반복문 제어 용
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 5개를 입력 하세요");
		
		for (i=0 ; i<5 ; i++)
			name[i]=sc.nextLine();
		System.out.println("입력된 이름: ");			
		
		for (i=0 ; i<5 ; i++)
			name[i]=sc.nextLine();
		System.out.print(name[i]+",");			
		

	}

}
