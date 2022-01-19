package org.day2;
import java.util.Scanner;
public class SwitchTest3 {

	public static void main(String[] args) {
		int score;
		char grade='E';
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요?(0~100)");
		score=sc.nextInt(); 

		if (score>=90 && score<=100) 
			grade='A';
		else if (score>=80 && score<=89) 
			grade='B';
		else if (score>=70 && score<=79) 
			grade='C';
		else if (score>=60 && score<=69) 
			grade='D';
		else if (score>=0 && score<60) 
			grade='F';
		else
			System.out.println("잘못된 점수 입니다. ");
		
	if(score>=0 && score<=100)
	System.out.println(score + "점은 "+grade);
		
		
	}

}
