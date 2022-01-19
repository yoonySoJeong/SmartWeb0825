package org.day2;

import java.util.Scanner;

public class Time {

	public static void main(String[] args) {
        int time,second,minute,hour;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("초를 입력하세요?");
	    time=sc.nextInt();
	    
	    second=time%60; // time를 60으로 나눈 나머지
	    minute=(time/60)%60; //60으로 나눈 몫을 다시 60으로 나눈 나머지
	    hour=(time/60)/60; // time를 60으로 나누고 다시 60으로 나눈 
	    
	    
	    System.out.println(time+" 초는 "+hour+" 시간, "+minute+" 분, "+second+" 초입니다.");
	    		
        /*
        System.out.println(time+" 초는 ");
        System.out.println(hour+" 시간, ");
        System.out.println(minute+" 분, ");
        System.out.println(second+" 초입니다.");
        */
	    
	    
	}

}
