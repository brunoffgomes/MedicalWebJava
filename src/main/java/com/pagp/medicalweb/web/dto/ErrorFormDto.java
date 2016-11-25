package com.pagp.medicalweb.web.dto;

public class ErrorFormDto extends BaseFormDto {

	/**
	 *
	 */
	private static final long serialVersionUID = 2812440411629616796L;

	private int errorCode;

	public ErrorFormDto(String mensaje) {
		this.setMensaje(mensaje);
		this.setStatus(ResponseStatusEnum.FAIL);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
