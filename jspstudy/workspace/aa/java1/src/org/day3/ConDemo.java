package org.day3;

public class ConDemo {

	public static void main(String[] args) {
	for (int i=0 ; i<=10 ; i++) {
		if(i%2==0)   // 2의 배수 이면 증감으로 이동해서 출력 안됨 0도 짝, 반복문을 중단 안하고 제 
			continue;
		System.out.print(i+ "  ");
	}

	}

}
