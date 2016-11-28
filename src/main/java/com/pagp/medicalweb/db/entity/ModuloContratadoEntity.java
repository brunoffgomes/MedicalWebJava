package com.pagp.medicalweb.db.entity;

import java.util.Date;

public class ModuloContratadoEntity {

	private int idContrato;
	private int idModulo;
	private int idEntidad;
	private double precio;
	private Date fInicio;
	private Date fFinal;
	
	public int getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}
	public int getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}
	public int getIdEntidad() {
		return idEntidad;
	}
	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getfInicio() {
		return fInicio;
	}
	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}
	public Date getfFinal() {
		return fFinal;
	}
	public void setfFinal(Date fFinal) {
		this.fFinal = fFinal;
	}
	
}
