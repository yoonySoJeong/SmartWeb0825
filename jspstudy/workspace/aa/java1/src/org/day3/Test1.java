package org.day3;
import java.util.Scanner;
public class Test1 {

	public static void main(String[] args) {
		
		int su,i;  //i 제어 변수 (몇번 반복?)
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수 입?");
	    su=sc.nextInt();
	    
	    for(i=0;i<su;i++) { // i 가 0에서시작 해서 su 보다 작을때 까지 ++ (1씩 증가 한다)
	         System.out.print("*");   } // for(i=0;i<su;i=i+2); 2,4,6,8로 증가 
	    }
	    

	

}
