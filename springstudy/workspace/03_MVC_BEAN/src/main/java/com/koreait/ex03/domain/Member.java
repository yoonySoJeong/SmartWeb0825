package com.koreait.ex03.domain;

public class Member {
	
	// DTO의 역할을 한다
	private String id;
	private String pw;
	
	// constructor
	public Member() {
		
	}

	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	// getter / setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}
