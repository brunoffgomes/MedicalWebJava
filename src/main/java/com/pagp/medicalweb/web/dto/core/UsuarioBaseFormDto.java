package com.pagp.medicalweb.web.dto.core;

import java.io.Serializable;

public class UsuarioBaseFormDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1800327618827556721L;
	
	private int idUser;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	

	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	
}
