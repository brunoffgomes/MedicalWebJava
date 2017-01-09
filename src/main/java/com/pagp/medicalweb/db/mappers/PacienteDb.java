package com.pagp.medicalweb.db.mappers;

import java.util.List;

import com.pagp.medicalweb.db.entity.receta.PacienteEntity;
import com.pagp.medicalweb.db.entity.receta.SolicitudEntity;

public interface PacienteDb {

	List<PacienteEntity> getPacientesByEntidad(int idEntidad);

	PacienteEntity getPaciente(int idPaciente);

	List<SolicitudEntity> getSolicitudes(int idPaciente);

}
