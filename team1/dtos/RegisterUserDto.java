package com.oracle.team1.dtos;

public class RegisterUserDto {
	private String email;
    
    private String password;
    
    private String fullName;
    
    private String role;

	public RegisterUserDto() {
		super();
	}

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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RegisterUserDto [email=" + email + ", password=" + password + ", fullName=" + fullName + ", role=" + role + "]";
	}

	public RegisterUserDto(String email, String password, String fullName, String role) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.role = role;
	}
    
    
}	
