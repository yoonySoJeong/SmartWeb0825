package org.day4;

public class SkewdeArray {

	public static void main(String[] args) {
		int a[][] = new int [4][];
		int i,j;
		
		a[0] = new int [3];
		a[1] = new int [2];
		a[2] = new int [3];
		a[3] = new int [2];
		
		for (i=0 ; i<a.length ; i++) { // length 는 내용 수
			for (j=0 ; j<a[i].length ; j++) 
				System.out.print(a[i][j]+ "  ");
		    System.out.println();
		}
		
		
	}

}
