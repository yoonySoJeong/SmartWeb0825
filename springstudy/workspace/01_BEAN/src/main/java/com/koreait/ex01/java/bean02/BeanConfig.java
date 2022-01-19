package com.koreait.ex01.java.bean02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	public Student s() {	// <bean class="Student" id="s">
		
		Student student = new Student();	// 생성자를 만들지 않았기 때문에, default로만 만들 수 있음

		Map<String, String> info = new HashMap<String, String>();
		info.put("name", "나학생");
		info.put("address", "서울시 영등포구 여의도동");
		info.put("tel", "010-1111-5555");
		student.setInfo(info);			// info ["name" : "나학생", "address" : "서울시 영등포구 여의도동", "tel" : "010-111-5555"] 가 들어가 있는 상태
		
		List<Integer> scores = Arrays.asList(50, 60, 70, 80, 90);
		student.setScores(scores);		// scores : 50 60 70 80 90이 들어가 있는 상태
		
		Set<String> awards = new HashSet<String>();	// 정렬이 순서대로 됨
		awards.add("인기상");
		awards.add("개근상");
		awards.add("Z");
		awards.add("B");
		awards.add("C");
		awards.add("F");
		awards.add("1");
		student.setAwards(awards);
		
		return student;
	}
	
}
