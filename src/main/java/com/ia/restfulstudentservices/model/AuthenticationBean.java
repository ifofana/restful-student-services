package com.ia.restfulstudentservices.model;

public class AuthenticationBean {
	
	private String text;

	public AuthenticationBean(String text) {
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
		return String.format("AuthenticationBean [text=%s", text);
	}
	
	
}
