package com.ia.restfulstudentservices.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;

//	{
//	"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmb2ZhbmEiLCJleHAiOjE1NjM5ODg3OTMsImlhdCI6MTU2MzM4Mzk5M30.jYo0vurtniROrDhHaxafTQ2B1pRv1oFZb3aGvPlfwaZGE7zeVD2IzFlNQw9IWwrKBCpXr-CHf5yW6ZaRuGpRLg"
//	}

//	{
//	"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU2NDY2ODA3MywiaWF0IjoxNTY0MDYzMjczfQ.JhHmkZxNR7w5flxSV7vqrr_3TkbCComwnVv5CBkET2FEDj3SNmmucrFPs1nxiXoxOWvvYa2XLKoZIObS28SoLg"
//	}

	public JwtTokenRequest() {
		super();
	}

	public JwtTokenRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
