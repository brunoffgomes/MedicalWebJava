package com.pagp.medicalweb.db.entity;

public class DoctorEntity extends UserDataEntity {

	private int idDoctor;
	private String especialidad;
	private String sub_especialidad;
	private String cedula_profesional;
	private int idEntidad;

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getSub_especialidad() {
		return sub_especialidad;
	}

	public void setSub_especialidad(String sub_especialidad) {
		this.sub_especialidad = sub_especialidad;
	}

	public String getCedula_profesional() {
		return cedula_profesional;
	}

	public void setCedula_profesional(String cedula_profesional) {
		this.cedula_profesional = cedula_profesional;
	}

	public int getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}

}
