package com.pagp.medicalweb.db.entity.receta;

public class SolicitudEntity {

	private int idSolicitud;
	private String tipo_solicitud;
	private int idPaciente;
	private String descripcion;
	private String impresion;
	private String estatus;

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getTipo_solicitud() {
		return tipo_solicitud;
	}

	public void setTipo_solicitud(String tipo_solicitud) {
		this.tipo_solicitud = tipo_solicitud;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImpresion() {
		return impresion;
	}

	public void setImpresion(String impresion) {
		this.impresion = impresion;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

}
