package com.pagp.medicalweb.web.dto;

import java.io.Serializable;

public class BaseFormDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3403958876187592023L;

	private ResponseStatusEnum status = ResponseStatusEnum.SUCCESS;
	private String mensaje;

	public ResponseStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusEnum status) {
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
