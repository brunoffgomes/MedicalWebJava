package com.pagp.medicalweb.web.dto;

import java.io.Serializable;

public class UserLogginFormInDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8341577235567761922L;

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
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
