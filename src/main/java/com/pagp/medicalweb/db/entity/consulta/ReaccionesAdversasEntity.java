package com.pagp.medicalweb.db.entity.consulta;

public class ReaccionesAdversasEntity {

	private int idReacciones;
	private int idEntidad;
	private String nombre;

	public int getIdReacciones() {
		return idReacciones;
	}

	public void setIdReacciones(int idReacciones) {
		this.idReacciones = idReacciones;
	}

	public int getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
