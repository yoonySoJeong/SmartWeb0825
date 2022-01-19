package com.koreait.ex01.java.bean03;

public class Publisher {
	
	/* field */
	private String name;
	private String tel;

	/* constructor */
	public Publisher() {
		
	}

	public Publisher(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}
	
	/*  getter / setter  */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
