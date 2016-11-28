package com.pagp.medicalweb.services.models;

import com.pagp.medicalweb.web.enums.UserLoginEstatusEnum;

public class UserLoginServicesOutDto {
	
	private String token;
	private UserLoginEstatusEnum estatus;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UserLoginEstatusEnum getEstatus() {
		return estatus;
	}
	public void setEstatus(UserLoginEstatusEnum estatus) {
		this.estatus = estatus;
	}
	
}
