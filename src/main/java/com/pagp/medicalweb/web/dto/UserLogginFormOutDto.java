package com.pagp.medicalweb.web.dto;

import java.util.Date;

import com.pagp.medicalweb.web.enums.UserLoginEstatusEnum;

public class UserLogginFormOutDto extends BaseFormDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6896209534958074595L;
	
	private String token;
	private Date expires;
	private String tipoUsuario;
	private UserLoginEstatusEnum estatus;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getExpires() {
		return expires;
	}
	public void setExpires(Date expires) {
		this.expires = expires;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public UserLoginEstatusEnum getEstatus() {
		return estatus;
	}
	public void setEstatus(UserLoginEstatusEnum estatus) {
		this.estatus = estatus;
	}
	
	
}

