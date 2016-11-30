package com.pagp.medicalweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.EntidadesDao;
import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;

@Service
@Transactional
public class EntidadesServices {

	@Autowired
	private EntidadesDao entidadesDao;

	public List<EntidadEntity> obtenerEntidades(int idAdministrador) {
		return entidadesDao.obtenerEntidades(idAdministrador);
	}

	public List<ModuloContratadoEntity> obtenerModulosEntidadActuales(int idEntidad) {
		return entidadesDao.obtenerModulosEntidadActuales(idEntidad);
	}
}
