package com.pagp.medicalweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.PacientesDao;
import com.pagp.medicalweb.db.entity.receta.PacienteEntity;

@Service
@Transactional
public class PacientesServices {

	@Autowired
	private PacientesDao pacientesDao;

	public List<PacienteEntity> obtenerPacientes(int idEntidad) {
		return pacientesDao.obtenerPacientes(idEntidad);
	}

}
