package com.pagp.medicalweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.DoctoresDao;
import com.pagp.medicalweb.db.entity.DoctorEntity;
import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;
import com.pagp.medicalweb.db.entity.receta.DiagnosticoEntity;

@Service
@Transactional
public class DoctoresServices {

	@Autowired
	private DoctoresDao doctoresDao;

	public List<DoctorEntity> obtenerDoctores(int idEntidad) {
		return doctoresDao.getDoctoresByEntidad(idEntidad);
	}

	public DoctorEntity obtenerDoctor(int idDoctor) {
		return doctoresDao.getDoctor(idDoctor);
	}

	public List<ConsultaEntity> obtenerConsultas(int idEntidad) {
		return doctoresDao.obtenerConsultas(idEntidad);
	}

	public ConsultaEntity obtenerConsulta(int idSolicitud) {
		return doctoresDao.obtenerConsulta(idSolicitud);
	}

	public List<DiagnosticoEntity> obtenerDiagnosticos(int idDoctor) {
		return doctoresDao.obtenerDiagnosticos(idDoctor);
	}

	public DiagnosticoEntity obtenerDiagnostico(int idDiagnostico) {
		return doctoresDao.obtenerDiagnostico(idDiagnostico);
	}
}
