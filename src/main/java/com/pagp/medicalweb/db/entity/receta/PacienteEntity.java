package com.pagp.medicalweb.db.entity.receta;

public class PacienteEntity {

	private int idPaciente;
	private String curp;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private String nivel_socioeconomico;
	private String vivienda;
	private String tipo_sanguinio;
	private String discapacidad;
	private String grupo_etnico;
	private String religion;
	private int idEntidad;

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getNivel_socioeconomico() {
		return nivel_socioeconomico;
	}

	public void setNivel_socioeconomico(String nivel_socioeconomico) {
		this.nivel_socioeconomico = nivel_socioeconomico;
	}

	public String getVivienda() {
		return vivienda;
	}

	public void setVivienda(String vivienda) {
		this.vivienda = vivienda;
	}

	public String getTipo_sanguinio() {
		return tipo_sanguinio;
	}

	public void setTipo_sanguinio(String tipo_sanguinio) {
		this.tipo_sanguinio = tipo_sanguinio;
	}

	public String getDiscapacidad() {
		return discapacidad;
	}

	public void setDiscapacidad(String discapacidad) {
		this.discapacidad = discapacidad;
	}

	public String getGrupo_etnico() {
		return grupo_etnico;
	}

	public void setGrupo_etnico(String grupo_etnico) {
		this.grupo_etnico = grupo_etnico;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public int getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}

}
