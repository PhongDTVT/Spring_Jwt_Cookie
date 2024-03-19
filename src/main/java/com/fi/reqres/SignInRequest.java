package com.fi.reqres;

public class SignInRequest {
	private String email;

    private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SignInRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public SignInRequest() {
		super();
	}
    
}
