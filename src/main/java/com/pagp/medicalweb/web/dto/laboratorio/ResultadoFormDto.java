package com.pagp.medicalweb.web.dto.laboratorio;

import java.util.List;

public class ResultadoFormDto {

	private int idResultado;
	private List<EvidenciaFormDto> evidencias;
	private String observaciones;

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
