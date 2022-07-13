package com.example.testing1.model;

import org.springframework.stereotype.Component;

@Component
public class JwtRequest {
  
	String email;
	String password;
	public JwtRequest() {
		
	}
public JwtRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	@Override
public String toString() {
	return "JwtRequest [email=" + email + ", password=" + password + "]";
}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
