package org.day3;
import java.util.Scanner;
public class ArrayLength {

	public static void main(String[] args) {
        int a[]=new int[5];
        int sum=0;
        
		Scanner sc = new Scanner(System.in);
		System.out.print(a.length+"5개의 점수를 입력하세요>>");
	
		for (int i=0 ; i<a.length ; i++) {
	    	a[i]=sc.nextInt();
	    	sum+=a[i];
		}
		System.out.println("평균은 "+ (double)sum/a.length);
		sc.close();
		

	}

}
