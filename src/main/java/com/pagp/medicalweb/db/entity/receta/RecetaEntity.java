package com.pagp.medicalweb.db.entity.receta;

import java.util.ArrayList;
import java.util.List;

import com.pagp.medicalweb.db.entity.DoctorEntity;

public class RecetaEntity {

	private int idReceta;
	private String comentarios;
	private String estatus;
	private PacienteEntity paciente;
	private DoctorEntity doctor;
	private List<MedicamentoRecetaEntity> medicamentos = new ArrayList<>();

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}

	public List<MedicamentoRecetaEntity> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<MedicamentoRecetaEntity> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

}
