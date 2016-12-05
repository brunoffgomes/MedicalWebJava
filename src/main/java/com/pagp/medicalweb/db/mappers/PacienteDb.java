package com.pagp.medicalweb.db.mappers;

import java.util.List;

import com.pagp.medicalweb.db.entity.receta.PacienteEntity;

public interface PacienteDb {

	List<PacienteEntity> getPacientesByEntidad(int idEntidad);

	PacienteEntity getPaciente(int idPaciente);

}
