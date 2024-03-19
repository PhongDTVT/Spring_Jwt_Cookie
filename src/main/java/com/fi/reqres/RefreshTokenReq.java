package com.fi.reqres;

public class RefreshTokenReq {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public RefreshTokenReq(String token) {
		super();
		this.token = token;
	}

	public RefreshTokenReq() {
		super();
	}
	
	
}
