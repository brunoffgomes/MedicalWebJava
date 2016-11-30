package com.pagp.medicalweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;
import com.pagp.medicalweb.db.mappers.EntidadDb;

@Repository
public class EntidadesDao {

	@Autowired
	private EntidadDb db;

	public List<EntidadEntity> obtenerEntidades(int idAdministrador) {
		return db.obtenerEntidades(idAdministrador);
	}

	public List<ModuloContratadoEntity> obtenerModulosEntidadActuales(int idEntidad) {
		return db.obtenerModulosEntidadActuales(idEntidad);
	}
}
