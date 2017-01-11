package com.pagp.medicalweb.db.entity;

public class FarmacologoEntity extends UsuarioEntity {

	private int idFarmacologo;
	private String cedula_profesional;
	private int idEntidad;

	public int getIdFarmacologo() {
		return idFarmacologo;
	}

	public void setIdFarmacologo(int idFarmacologo) {
		this.idFarmacologo = idFarmacologo;
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
