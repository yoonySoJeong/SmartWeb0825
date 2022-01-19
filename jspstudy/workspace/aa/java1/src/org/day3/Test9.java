package org.day3;

public class Test9 {

	public static void main(String[] args) {
		int a[][]= {{10,20,30,40},{50,60,70,80}};
		int i,j,sum=0;
		
		
		for (i=0 ; i<2 ; i++) {
			for(j=0 ; j<4 ; j++)
				sum+=a[i][j]; //계속 누적 
			}
			System.out.println("합계는 "+ sum);
			
			}
		}

	
