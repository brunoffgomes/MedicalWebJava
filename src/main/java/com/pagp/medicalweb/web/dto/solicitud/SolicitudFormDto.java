package com.pagp.medicalweb.web.dto.solicitud;

import com.pagp.medicalweb.web.enums.EstatusSolicitudEnum;
import com.pagp.medicalweb.web.enums.TipoSolicitudEnum;

public class SolicitudFormDto {

	private int idSolicitud;
	private TipoSolicitudEnum tipo_solicitud = TipoSolicitudEnum.CONSULTA;
	private int idPaciente;
	private String descripcion;
	private String impresion;
	private EstatusSolicitudEnum estatus = EstatusSolicitudEnum.ABIERTA;

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public TipoSolicitudEnum getTipo_solicitud() {
		return tipo_solicitud;
	}

	public void setTipo_solicitud(TipoSolicitudEnum tipo_solicitud) {
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

	public void setDescripion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImpresion() {
		return impresion;
	}

	public void setImpresion(String impresion) {
		this.impresion = impresion;
	}

	public EstatusSolicitudEnum getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusSolicitudEnum estatus) {
		this.estatus = estatus;
	}

}
