package org.day4;
import java.util.Scanner;
public class ArrayTest3 {

	public static void main(String[] args) {
		int a[]= new int[5];
		int i, sum=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 5개 입력 >>");
		for (i=0 ; i<5 ; i++) {
			a[i]=sc.nextInt();
			if (a[i]>0)
				sum+=a[i]; //sum = sum+a[i]		
		}
		System.out.println("sum="+sum);	
		
	}

}
