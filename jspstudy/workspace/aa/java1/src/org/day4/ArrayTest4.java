package org.day4;

public class ArrayTest4 {

	public static void main(String[] args) {
		int a[][] = {{1,2,3},{4,5,6},{7,8,9}} ;
		int i,j ;
		
		for (i=0 ; i<3 ; i++)
			for (j=0 ; j<3 ; j++)
				if (i==j)
					System.out.print(a[i][j]+ " ") ; }

	}


