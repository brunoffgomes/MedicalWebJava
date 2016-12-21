package com.pagp.medicalweb.db.entity.administrador;

import java.util.Date;

import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.web.dto.core.TipoUsuarioEnum;

public class MiPerfilEntity {

	private int idUser;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String email;
	private Date fechaNacimiento;
	private TipoUsuarioEnum tipo;
	private EntidadEntity entidad;

	public EntidadEntity getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadEntity entidad) {
		this.entidad = entidad;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public TipoUsuarioEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuarioEnum tipo) {
		this.tipo = tipo;
	}
}
