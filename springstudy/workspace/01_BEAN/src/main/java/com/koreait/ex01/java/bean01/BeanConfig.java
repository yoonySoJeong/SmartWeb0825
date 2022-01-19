package com.koreait.ex01.java.bean01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
  	@Configuration
  	안녕 난 Bean을 만드는 Java 클래스야  -- @Configuration을 override 하면 된다.
  	날 이용하려면 cglib 디펜던시를 추가해야 돼	-- mvn dependency
 */

@Configuration
public class BeanConfig {
	
	// 메소드 1개 = Bean 1개
	// Bean을 만드는 메소드는 @Bean 애너테이션이 필요함
	
	// 반환타입 : Song 		<bean class="Song">		-- 객체 생성 Class
	// 메소드명 : mySong 	<bean id="mySong">		-- 객체 이름
	@Bean
	public Song mySong() {	// mySong이 Bean이라는 뜻
		// Setter injection을 하든 constructor injection을 하든 자유!
		// Song result = new Song("hello", "balad"); << 직접 채워주는 constructor-arg injection을 하는 방법
		Song result = new Song();		// setter를 이용한 injection
		result.setTitle("hello");		// <property>
		result.setGenre("balad");		// <property>
		return result;	// result 에는 title/genre가 저장되어 있는 상태
	}
	
	@Bean
	public Singer mySinger() { // <bean class="Singer" id="mySinger">
		
		return new Singer("adele", mySong());	// <constructor-arg>	-- Bean에다 직접 채워주는 constructor-arg
		
	}
	
}
