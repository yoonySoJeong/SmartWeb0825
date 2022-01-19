package org.day4;

public class ArrayTest6 {

	public static void main(String[] args) {
		int a[][] = {{1},{1,2,3},{9},{7,8,9,4},{3,8}};  // [][]두개는 행과 열을 나타
		int i,j;
		
		for (i=0 ; i<a.length ; i++) {
			for (j=0 ; j<a[i].length ; j++)
				System.out.print(a[i][j]+ "  ");
			System.out.println();
		}
		
		
		
		
	}

}
