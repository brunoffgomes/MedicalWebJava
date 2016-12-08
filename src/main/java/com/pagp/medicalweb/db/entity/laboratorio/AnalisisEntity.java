package com.pagp.medicalweb.db.entity.laboratorio;

import java.util.Date;

public class AnalisisEntity {

	private int idAnalisis;
	private Date fecha;
	private String estatus;
	private String observaciones;
	private int idLaboratorista;

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

}
