package com.koreait.ex01.java.bean02;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
	
	// field
	private Map<String, String> info;	// 학생의 정보 - Map 사용
	private List<Integer> scores;		// 과목당 점수 - list 사용	: 특징 index가 있음
	private Set<String> awards;			// 수상 경력 - Set사용 : 특징 중복은 나오지 않음
	
	// constructor는 default 생성자를 사용
	// getter / setter
	public Map<String, String> getInfo() {
		return info;
	}
	public void setInfo(Map<String, String> info) {
		this.info = info;
	}
	public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	public Set<String> getAwards() {
		return awards;
	}
	public void setAwards(Set<String> awards) {
		this.awards = awards;
	}
	
	
}
