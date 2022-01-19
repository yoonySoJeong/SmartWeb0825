


// 이거 실행하면 멈취 버림!!!

package org.day2;

public class ForDemo {

	public static void main(String[] args) {
		int sum=0;
		for(int i=1;1<=10;i++) {
			
		sum+=i;
		System.out.print(i);
		
		if(i<=9)
			System.out.print("+");
		else {
			System.out.print("=");
			System.out.print(sum);
		}
		}

	}

}
