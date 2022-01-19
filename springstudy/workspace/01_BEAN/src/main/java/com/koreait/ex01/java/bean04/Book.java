package com.koreait.ex01.java.bean04;

public class Book {
	
	/* FIELD */
	private String title;
	private String author;
	private Publisher publisher;
	
	/* CONSTRUCTOR */
	public Book() {
		
	}

	public Book(String title, String author, Publisher publisher) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	/* GETTER / SETTER */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
}
