package com.pagp.medicalweb.db.entity.laboratorio;

public class MuestraEntity {

	private int idMuestra;
	private int idAnalisis;
	private String tipo_muestra;
	private int numero;

	public int getIdMuestra() {
		return idMuestra;
	}

	public void setIdMuestra(int idMuestra) {
		this.idMuestra = idMuestra;
	}

	public int getIdAnalisis() {
		return idAnalisis;
	}

	public void setIdAnalisis(int idAnalisis) {
		this.idAnalisis = idAnalisis;
	}

	public String getTipo_muestra() {
		return tipo_muestra;
	}

	public void setTipo_muestra(String tipo_muestra) {
		this.tipo_muestra = tipo_muestra;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
