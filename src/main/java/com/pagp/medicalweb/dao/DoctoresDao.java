package com.pagp.medicalweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.DoctorEntity;
import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;
import com.pagp.medicalweb.db.entity.receta.DiagnosticoEntity;
import com.pagp.medicalweb.db.mappers.DoctorDb;

@Repository
public class DoctoresDao {

	@Autowired
	private DoctorDb db;

	public List<DoctorEntity> getDoctoresByEntidad(int idEntidad) {
		return db.getDoctoresByEntidad(idEntidad);
	}

	public DoctorEntity getDoctor(int idDoctor) {
		return db.getDoctor(idDoctor);
	}

	public List<ConsultaEntity> obtenerConsultas(int idEntidad) {
		return db.getConsultas(idEntidad);
	}

	public ConsultaEntity obtenerConsulta(int idSolicitud) {
		return db.getConsulta(idSolicitud);
	}

	public List<DiagnosticoEntity> obtenerDiagnosticos(int idDoctor) {
		return db.getDiagnosticos(idDoctor);
	}

	public DiagnosticoEntity obtenerDiagnostico(int idDiagnostico) {
		return db.getDiagnostico(idDiagnostico);
	}
}
