package com.oracle.team1.entity;

public class LoginResponse {
	private String token;

    private long expiresIn;

    public String getToken() {
        return token;
    }

	public LoginResponse() {
		super();
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "LoginResponse [token=" + token + ", expiresIn=" + expiresIn + "]";
	}
    
    
}
