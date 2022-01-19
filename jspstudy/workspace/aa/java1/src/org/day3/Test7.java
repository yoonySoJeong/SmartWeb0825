package org.day3;
import java.util.Scanner;
public class Test7 {

	public static void main(String[] args) {
       int su,sib,il;
       
       Scanner sc = new Scanner(System.in);
		System.out.println("2자리 정수 입력?(10~99)");
	    su=sc.nextInt();
	    sib=su/10; il=su%10;
	    
	    if (sib==il)
     	    System.out.println("10의 자리와 1의 자리가 같다.");
	    else System.out.println("10의 자리와 1의 자리가 같지않다.");    
	    
	}

}
