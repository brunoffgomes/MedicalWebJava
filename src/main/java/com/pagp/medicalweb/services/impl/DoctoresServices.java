package com.pagp.medicalweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.DoctoresDao;
import com.pagp.medicalweb.db.entity.DoctorEntity;

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

}
