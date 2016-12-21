package com.pagp.medicalweb.web.core.dto;

public class JwtUserDto {

	private int id;
	private String username;
	private String role;
	private int idEntidad;
	private String[] modulosActivos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String[] getModulosActivos() {
		return modulosActivos;
	}

	public void setModulosActivos(String[] modulosActivos) {
		this.modulosActivos = modulosActivos;
	}
}