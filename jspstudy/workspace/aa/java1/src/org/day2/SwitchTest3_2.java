package org.day2;
import java.util.Scanner;
public class SwitchTest3_2 {

	public static void main(String[] args) {
		int score,s;
	
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요?(0~100)");
		score=sc.nextInt(); 
        s=score/10;
		
		switch(s) {
		case 10:
		case 9:
			System.out.println("A 학점");break;
		case 8:
			System.out.println("B 학점");break;
		case 7:
			System.out.println("C 학점");break;
		case 6:
			System.out.println("D 학점");break;
		case 5,4,3,2,1:
			System.out.println("F 학점");break;
		default: System.out.println("잘못된 점수 입니다.");
		// case 구문은 범위 지정이 불가능 함, 0~9점 사이의 점수 산출이 불가능 하니 다른게 해야 
			}
	}
}