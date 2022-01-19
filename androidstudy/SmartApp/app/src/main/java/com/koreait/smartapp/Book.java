package com.koreait.smartapp;

public class Book {

    private String image;
    private String title;
    private String content;

    public Book(String image, String title, String content) {
        this.image = image;
        this.title = title;
        this.content = content;
    }

    public String getBookCover() {
        return image;
    }

    public void setBookCover(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
