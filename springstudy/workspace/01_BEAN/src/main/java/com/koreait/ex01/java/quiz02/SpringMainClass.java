package com.koreait.ex01.java.quiz02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		Soldier soldier1 = ctx.getBean("soldier1", Soldier.class);
		soldier1.soldierInfo();
		System.out.println("----------------");
		
		Soldier soldier2 = ctx.getBean("soldier2", Soldier.class);
		soldier2.soldierInfo();		// bean 내에서 method 만드는거 공부하기
		
		ctx.close();
		
	}

}
