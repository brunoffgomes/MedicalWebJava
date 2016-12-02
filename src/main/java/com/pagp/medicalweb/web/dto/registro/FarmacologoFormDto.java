package com.pagp.medicalweb.web.dto.registro;

import com.pagp.medicalweb.web.dto.core.UsuarioBaseFormDto;

public class FarmacologoFormDto extends UsuarioBaseFormDto {

	/**
	 *
	 */
	private static final long serialVersionUID = -3180398483983861213L;
	private int idEntidad;
	private String cedula_profesional;
	private int idFarmacologo;

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

	public int getIdFarmacologo() {
		return idFarmacologo;
	}

	public void setIdFarmacologo(int idFarmacologo) {
		this.idFarmacologo = idFarmacologo;
	}

}
