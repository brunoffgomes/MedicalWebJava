package com.pagp.medicalweb.db.entity.receta;

import com.pagp.medicalweb.db.entity.UserDataEntity;

public class ConsultaEntity extends SolicitudEntity {

	private PacienteEntity paciente;
	private UserDataEntity atendio;

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}

	public UserDataEntity getAtendio() {
		return atendio;
	}

	public void setAtendio(UserDataEntity atendio) {
		this.atendio = atendio;
	}
	
	
}
