package org.day2;
import java.util.Scanner;
public class SwitchDemo {

	public static void main(String[] args) {
		int month;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("달을 입력해 주세요 (1~12)");
		month=sc.nextInt();

	    switch(month) {
	    case 12,1,2:
	    	System.out.println("겨울");break; 
	    case 3,4,5:
	    	System.out.println("봄");break; 
	    case 6,7,8:
	    	System.out.println("여름");break; 
	    case 9,10,11:
	    	System.out.println("가을");break; 
	    default: System.out.println("잘못된 달입니다.");	    
	    
	    }
		
	}

}
