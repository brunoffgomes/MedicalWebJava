package com.pagp.medicalweb.db.entity;

public class LaboratoristaEntity {

	private int idLaboratorista;
	private String cedula_profesional;
	private int idEntidad;

	public int getIdLaboratorista() {
		return idLaboratorista;
	}

	public void setIdLaboratorista(int idLaboratorista) {
		this.idLaboratorista = idLaboratorista;
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
