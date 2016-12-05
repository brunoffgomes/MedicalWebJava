package com.pagp.medicalweb.db.entity;

public class AdministradorCEEntity {

	private int idAdministradorCE;
	private String cedula_profesional;
	private int idEntidad;
	private String cargo;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getIdAdministradorCE() {
		return idAdministradorCE;
	}

	public void setIdAdministradorCE(int idAdministradorCE) {
		this.idAdministradorCE = idAdministradorCE;
	}

	public int getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getCedula_profesional() {
		return cedula_profesional;
	}

	public void setCedula_profesional(String cedula_profesional) {
		this.cedula_profesional = cedula_profesional;
	}

}
