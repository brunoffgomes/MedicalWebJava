package com.pagp.medicalweb.services.enums;

public enum AuditingActionTypeEnum {

	PACIENTE_CREADO("Paciente Creado"), SOLICITUD_SERVICIO("Solicitud de Servicio");

	private String mDescription;

	private AuditingActionTypeEnum(String aDescription) {
		mDescription = aDescription;
	}

	public String getDescription() {
		return mDescription;
	}

	public void setDescription(String aDescription) {
		mDescription = aDescription;
	}

}