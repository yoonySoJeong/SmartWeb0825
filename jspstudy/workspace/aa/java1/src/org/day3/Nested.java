package org.day3;

public class Nested {

	public static void main(String[] args) {
		int i,j;
		for (i=0;i<3;i++) {  // i=0,1,2
			for(j=0;j<4;j++) // j=0,1,2,3 위와 곱으로 해서 총 12번 반
				System.out.print(j+ "  ");
		}

	}

}
