package org.day4;

import java.util.Random;
import java.util.Scanner;

public class ArrayTest5 {

	public static void main(String[] args) {
		
		int com, user=0;
		Random r = new Random();
		com = r.nextInt(100);
		Scanner sc = new Scanner (System.in);
		while(com!=user) {
			System.out.println("0~99사이의 정수 입력 하세요?");
			user = sc.nextInt();
			if (com==user) {
				System.out.println("맞추었습니다."); break;
			}
			else if (com>user)
				System.out.println("입력한 값보다 더 큰 수 입니다. ");
			else
     			System.out.println("입력한 값보다 작은 수 입니다. ");
			}
					
		}

	}


