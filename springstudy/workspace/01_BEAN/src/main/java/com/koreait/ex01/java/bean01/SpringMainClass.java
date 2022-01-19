package com.koreait.ex01.java.bean01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		// AnnotationConfigApplicationContext 클래스
		// 1. @Configuration과 @Bean을 이용한 Bean 생성
		// 2. AbstractApplicationContext 클래스의 자식 클래스
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);	// 어디에 bean을 만들어 두었느냐 -> Class명.class 를 넣어서 class임을 명시해준다
		
		Singer singer = ctx.getBean("mySinger", Singer.class);
		System.out.println("가수 이름 : " + singer.getName());
		System.out.println("노래 제목 : " + singer.getSong().getTitle());
		System.out.println("노래 장르 : " + singer.getSong().getGenre());
		
		ctx.close();
		
	}

}
