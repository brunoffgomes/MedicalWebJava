package com.pagp.medicalweb.db.entity.consulta;

public class Alergias {

	private int idAlergia;
	private int idEntidad;
	private String nombre;

	public int getIdAlergia() {
		return idAlergia;
	}

	public void setIdAlergia(int idAlergia) {
		this.idAlergia = idAlergia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}

}
