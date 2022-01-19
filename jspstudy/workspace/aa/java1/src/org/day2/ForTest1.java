package org.day2;
import java.util.Scanner;
public class ForTest1 {

	public static void main(String[] args)  {
       int dan=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("단 입력 (2~9)");
	    dan=sc.nextInt();

	   if (dan<2 || dan>9)
		   System.out.println();
	   
	   else
		   for(int i=1;i<=9;i++)
			   System.out.println(dan+ "X" + i + "=" + (dan*i));
	   sc.close();
	    
	    
	    
	}

}
