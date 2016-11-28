package com.pagp.medicalweb.web.dto.registro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pagp.medicalweb.web.dto.core.UsuarioBaseFormDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdministradorFormDto extends UsuarioBaseFormDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6907744048157580671L;
	private String cargo;
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
