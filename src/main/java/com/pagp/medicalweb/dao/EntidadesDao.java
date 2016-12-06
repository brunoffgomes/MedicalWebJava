package com.pagp.medicalweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.AdministradorCEEntity;
import com.pagp.medicalweb.db.entity.EnfermeroEntity;
import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.FarmacologoEntity;
import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;
import com.pagp.medicalweb.db.mappers.EntidadDb;

@Repository
public class EntidadesDao {

	@Autowired
	private EntidadDb db;

	public List<EntidadEntity> obtenerEntidades(int idAdministrador) {
		return db.obtenerEntidades(idAdministrador);
	}

	public List<EntidadEntity> obtenerEntidades() {
		return db.obtenerEntidadesAll();
	}

	public List<ModuloContratadoEntity> obtenerModulosEntidadActuales(int idEntidad) {
		return db.obtenerModulosEntidadActuales(idEntidad);
	}

	public EnfermeroEntity getEnfermero(int idEnfermero) {
		return db.getEnfermero(idEnfermero);
	}

	public FarmacologoEntity getFarmacologo(int idFarmacologoo) {
		return db.getFarmacologo(idFarmacologoo);
	}

	public AdministradorCEEntity getAdministradorCE(int idAdministradorCE) {
		return db.getAdministradorCE(idAdministradorCE);
	}

}
