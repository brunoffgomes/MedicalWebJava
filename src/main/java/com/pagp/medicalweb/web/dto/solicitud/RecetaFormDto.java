package com.pagp.medicalweb.web.dto.solicitud;

import java.util.ArrayList;
import java.util.List;

import com.pagp.medicalweb.web.enums.EstatusSolicitudEnum;

public class RecetaFormDto {

	private int idReceta;
	private String comentarios;
	private List<MedicamentoRecetaFormDto> medicamentos = new ArrayList<>();
	private EstatusSolicitudEnum estatus = EstatusSolicitudEnum.ABIERTA;

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public List<MedicamentoRecetaFormDto> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<MedicamentoRecetaFormDto> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public EstatusSolicitudEnum getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusSolicitudEnum estatus) {
		this.estatus = estatus;
	}

}
