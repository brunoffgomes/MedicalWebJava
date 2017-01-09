package com.pagp.medicalweb.web.dto.laboratorio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.pagp.medicalweb.services.auditoria.AuditingTargetPaciente;

public class AnalisisFormDto {

	private int idAnalisis;
	private Date fecha;
	private String estatus;
	private String observaciones;
	private int idLaboratorista;
	private List<MuestraFormDto> muestras = new ArrayList<>();
	@AuditingTargetPaciente
	private int idPaciente;

	public int getIdAnalisis() {
		return idAnalisis;
	}

	public void setIdAnalisis(int idAnalisis) {
		this.idAnalisis = idAnalisis;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getIdLaboratorista() {
		return idLaboratorista;
	}

	public void setIdLaboratorista(int idLaboratorista) {
		this.idLaboratorista = idLaboratorista;
	}

	public List<MuestraFormDto> getMuestras() {
		return muestras;
	}

	public void setMuestras(List<MuestraFormDto> muestras) {
		this.muestras = muestras;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
}
