package com.ia.restfulstudentservices.model;

public class HelloWorldBean {
	
	private String text;

	public HelloWorldBean(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return String.format("HelloWorldBean [text=%s", text);
	}
	
	
}
