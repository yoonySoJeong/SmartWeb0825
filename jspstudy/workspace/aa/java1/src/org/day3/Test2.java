package org.day3;
import java.util.Scanner;
public class Test2 {

	public static void main(String[] args) {
        int w,h,i,j;
       
        
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가로?");
	    w=sc.nextInt();
	    
	    System.out.println("세로?");
	    h=sc.nextInt();
	    
	    for (i=0;i<h;i++) {  
			for(j=0;j<w;j++) 
				System.out.print("*");
			System.out.println();
	    
	    }
	    
	}

}
