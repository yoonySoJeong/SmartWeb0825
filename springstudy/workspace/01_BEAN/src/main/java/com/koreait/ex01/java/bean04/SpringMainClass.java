package com.koreait.ex01.java.bean04;

import java.util.UUID;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		Book book1 = ctx.getBean("book1", Book.class);
		System.out.println(book1.getTitle());
		System.out.println(book1.getAuthor());
		System.out.println(book1.getPublisher().getName());
		System.out.println(book1.getPublisher().getTel());
		
		System.out.println("--- BEAN04 ---");
		
		Book book2 = ctx.getBean("book2", Book.class);
		System.out.println(book2.getTitle());
		System.out.println(book2.getAuthor());
		System.out.println(book2.getPublisher().getName());
		System.out.println(book2.getPublisher().getTel());
		
		ctx.close();
		
		   String uuid = UUID.randomUUID().toString();
	         System.out.println(uuid);
		
	}

}
