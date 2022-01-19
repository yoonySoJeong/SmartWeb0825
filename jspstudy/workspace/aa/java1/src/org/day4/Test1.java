package org.day4;
import java.util.Scanner;
public class Test1 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int i,j ; //항상 나오지만 행/열 제어
		System.out.println("소문자 입력 >>");
		String s=sc.next();  // 입력 받는거를 바로 변수 정의 
	    char c = s.charAt(0) ; // char 은 문자열이고,chast At 문자열의 몇 번째?
	    
	    for (i=c ; i<='a' ; i--) {
	    	for (j='a' ; j<=i ; j++)
	    		System.out.print((char)j);
	    	System.out.println();
	    }
		
		
	}

}
