package com.nagarro.nagp.account.dtos;

import javax.validation.constraints.NotNull;

public class LoginDto {

	@NotNull
	private String username;
	@NotNull
	private String password;

	public String getUsername() {
		return username;
	}

	public LoginDto(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
