package com.pagp.medicalweb.web.dto.solicitud;

import com.pagp.medicalweb.services.auditoria.AuditingTargetPaciente;
import com.pagp.medicalweb.web.enums.EstatusSolicitudEnum;

public class DiagnosticoFormDto {

	private int idDiagnostico;
	private int idDoctor;
	private String diagnostico;
	private String tratamiento;
	private EstatusSolicitudEnum estatus = EstatusSolicitudEnum.ABIERTA;
	@AuditingTargetPaciente
	private int idPaciente;

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(int idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public EstatusSolicitudEnum getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusSolicitudEnum estatus) {
		this.estatus = estatus;
	}
}
