package com.pagp.medicalweb.web.dto.laboratorio;

import java.util.List;

import com.pagp.medicalweb.services.auditoria.AuditingTargetPaciente;

public class ResultadoFormDto {

	private int idResultado;
	private List<EvidenciaFormDto> evidencias;
	private String observaciones;
	@AuditingTargetPaciente
	private int idPaciente;

	public List<EvidenciaFormDto> getEvidencias() {
		return evidencias;
	}

	public void setEvidencias(List<EvidenciaFormDto> evidencias) {
		this.evidencias = evidencias;
	}

	public int getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
