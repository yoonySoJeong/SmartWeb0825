package org.day3;
import java.util.Scanner;
public class Test5 {

	public static void main(String[] args) {
        int a[]=new int[5];
        int max=-9999;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 5개 입력하세요");
	
		for (int i=0 ; i<5 ; i++) {
	    	a[i]=sc.nextInt();
	    	if(a[i]>max)
	    		max=a[i];
	    				
		}
    	System.out.println("입력한 값:");
    	for (int i=0 ; i<5 ; i++) 
    		System.out.print(a[i]+" ");
    	
    	System.out.println("max 값은:"+max);  // 이거 마지막 수정 필
    	
    	sc.close();
    	

	}

}
