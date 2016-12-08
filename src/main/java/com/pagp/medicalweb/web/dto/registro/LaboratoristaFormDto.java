package com.pagp.medicalweb.web.dto.registro;

import com.pagp.medicalweb.web.dto.core.UsuarioBaseFormDto;

public class LaboratoristaFormDto extends UsuarioBaseFormDto {

	/**
	 *
	 */
	private static final long serialVersionUID = -3180398483983861213L;
	private int idEntidad;
	private String cedula_profesional;
	private int idLaboratorista;

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

	public int getIdLaboratorista() {
		return idLaboratorista;
	}

	public void setIdLaboratorista(int idLaboratorista) {
		this.idLaboratorista = idLaboratorista;
	}

}