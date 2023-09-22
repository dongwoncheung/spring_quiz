package com.quiz.lesson01;

public class Data {
	//필드
	private String title;
	private String user;
	private String content;
	//메소드
	public Data() {//기본
		
	}
	public Data(String title, String user, String content) {//parameter가 있는 생성자
		this.title = title;
		this.user = user;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
