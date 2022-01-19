package org.day3;
import java.util.Scanner;
public class ArrayDemo {

	public static void main(String[] args) {
		int a[]=new int[5];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 5개 입력하세요");
	    for (int i=0 ; i<5 ; i++) {
	    	a[i]=sc.nextInt();
	    }
	    	System.out.println("입력한 값:");
	    	for (int i=0 ; i<5 ; i++) 
	    		System.out.print(a[i]+" ");
	    	sc.close();
	    	
	}

}
