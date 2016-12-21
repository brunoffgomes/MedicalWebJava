package com.pagp.medicalweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.AdministradorCEEntity;
import com.pagp.medicalweb.db.entity.EnfermeroEntity;
import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.FarmacologoEntity;
import com.pagp.medicalweb.db.entity.LaboratoristaEntity;
import com.pagp.medicalweb.db.entity.administrador.DetalleModuloEntity;
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

	public List<DetalleModuloEntity> obtenerModulosEntidadActuales(int idEntidad) {
		return db.obtenerModulosEntidadActuales(idEntidad);
	}

	public List<DetalleModuloEntity> obtenerModulosEntidadActivos(int idEntidad) {
		return db.obtenerModulosEntidadActivos(idEntidad);
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

	public LaboratoristaEntity getLaboratorista(int idLaboratorista) {
		return db.getLaboratorista(idLaboratorista);
	}

}
