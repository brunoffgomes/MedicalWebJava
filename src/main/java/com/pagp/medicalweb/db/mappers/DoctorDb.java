package com.pagp.medicalweb.db.mappers;

import java.util.List;

import com.pagp.medicalweb.db.entity.DoctorEntity;
import com.pagp.medicalweb.db.entity.EnfermeroEntity;
import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;
import com.pagp.medicalweb.db.entity.receta.DiagnosticoEntity;

public interface DoctorDb {

	List<DoctorEntity> getDoctoresByEntidad(int idEntidad);

	List<EnfermeroEntity> getEnfermerosByEntidad(int idEntidad);

	DoctorEntity getDoctor(int idDoctor);

	List<ConsultaEntity> getConsultas(int idEntidad);

	ConsultaEntity getConsulta(int idSolicitud);

	List<DiagnosticoEntity> getDiagnosticos(int idDoctor);

	DiagnosticoEntity getDiagnostico(int idDiagnostico);

}
