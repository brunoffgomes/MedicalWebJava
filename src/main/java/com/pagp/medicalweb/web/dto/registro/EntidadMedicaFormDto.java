package com.pagp.medicalweb.web.dto.registro;

import java.util.List;

import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;

public class EntidadMedicaFormDto {

	private String nombre;
	private String calle;
	private String numero;
	private String codigoPostal;
	private String telefono;
	private String rfc;
	private TipoEntidadEnum tipo;
	private List<ModuloContratadoEntity> modulos;
	private AdministradorFormDto administrador;

	public AdministradorFormDto getAdministrador() {
		return administrador;
	}

	public void setAdministrador(AdministradorFormDto administrador) {
		this.administrador = administrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public TipoEntidadEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEntidadEnum tipo) {
		this.tipo = tipo;
	}

	public List<ModuloContratadoEntity> getModulos() {
		return modulos;
	}

	public void setModulos(List<ModuloContratadoEntity> modulos) {
		this.modulos = modulos;
	}
}
