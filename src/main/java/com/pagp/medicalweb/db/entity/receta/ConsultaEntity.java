package com.pagp.medicalweb.db.entity.receta;

public class ConsultaEntity extends SolicitudEntity {

	private PacienteEntity paciente;

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}
}
