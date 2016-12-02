package com.pagp.medicalweb.web.dto.registro;

import com.pagp.medicalweb.web.dto.core.UsuarioBaseFormDto;

public class EnfermeroFormDto extends UsuarioBaseFormDto {

	/**
	 *
	 */
	private static final long serialVersionUID = -3180398483983861213L;
	private int idEntidad;
	private String cedula_profesional;
	private int idEnfermero;

	public int getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}

	public int getIdEnfermero() {
		return idEnfermero;
	}

	public void setIdEnfermero(int idEnfermero) {
		this.idEnfermero = idEnfermero;
	}

	public String getCedula_profesional() {
		return cedula_profesional;
	}

	public void setCedula_profesional(String cedula_profesional) {
		this.cedula_profesional = cedula_profesional;
	}

}
