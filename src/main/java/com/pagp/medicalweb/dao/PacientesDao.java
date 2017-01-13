package com.pagp.medicalweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;
import com.pagp.medicalweb.db.entity.receta.PacienteEntity;
import com.pagp.medicalweb.db.mappers.PacienteDb;

@Repository
public class PacientesDao {

	@Autowired
	private PacienteDb db;

	public List<PacienteEntity> obtenerPacientes(int idEntidad) {
		return db.getPacientesByEntidad(idEntidad);
	}

	public PacienteEntity obtenerPaciente(int idPaciente) {
		return db.getPaciente(idPaciente);
	}

	public List<ConsultaEntity> getSolicitudes(int idPaciente) {
		return db.getSolicitudes(idPaciente);
	}
}
