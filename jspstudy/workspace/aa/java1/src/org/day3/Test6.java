package org.day3;

public class Test6 {

	public static void main(String[] args) {
		for (int i=1 ; i<=28 ; i++) {
			if (i%3!=0)
				continue;
			System.out.print(i+ "  ");
		}
		
		
		
		
		/* for (int i=1 ; i<=28 ; i++) {
			if(i%3==0)     // 3의 배수만 출력 안함
			continue;
			System.out.print(i+ "  ");
		}
        */
	}

}
