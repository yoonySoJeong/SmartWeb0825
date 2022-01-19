package org.day1;
import java.util.Scanner;
public class ThreeDemo {

	public static void main(String[] args) {
		int a,b,max;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 수 입?");
	    a=sc.nextInt();
		System.out.println("두번째  입력?");
		b=sc.nextInt();
		
	    max=(a>b)?a:b;
	    /* (a>b)?a 가 b 보다 크냐?
	    		그러면 a 로 출력하고 
	    		: 이건 아니면이네, 아니면 b 로 출력 */
		
		System.out.println("Max is? " + max);
		
		
		
		
		
	}

}
