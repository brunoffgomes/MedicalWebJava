package com.pagp.medicalweb.web.dto.registro;

import com.pagp.medicalweb.web.dto.core.UsuarioBaseFormDto;

public class AdministradorCEFormDto extends UsuarioBaseFormDto {
	/**
	 *
	 */
	private static final long serialVersionUID = -3180398483983861213L;
	private int idEntidad;
	private String cedula_profesional;
	private int idAdministradorCE;
	private String cargo;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}

	public int getIdAdministradorCE() {
		return idAdministradorCE;
	}

	public void setIdAdministradorCE(int idAdministradorCE) {
		this.idAdministradorCE = idAdministradorCE;
	}

	public String getCedula_profesional() {
		return cedula_profesional;
	}

	public void setCedula_profesional(String cedula_profesional) {
		this.cedula_profesional = cedula_profesional;
	}
}
