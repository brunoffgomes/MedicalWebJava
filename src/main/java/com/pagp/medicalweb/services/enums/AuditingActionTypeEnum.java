package com.pagp.medicalweb.services.enums;

public enum AuditingActionTypeEnum {

	PACIENTE_CREADO("Paciente Creado"),
	SOLICITUD_SERVICIO("Solicitud de Servicio"),
	ENTREGA_RECETA("Entrega de receta"),
	CREAR_RECETA("Crear Receta"),
	CREAR_DIAGNOSTICO("Crear Diagnosticos"),
	CREAR_RESULTADO("Crear resultado análisis"),
	CREAR_ANALISIS("Crear análisis");

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