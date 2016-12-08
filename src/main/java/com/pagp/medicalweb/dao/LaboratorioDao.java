package com.pagp.medicalweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.laboratorio.AnalisisEntity;
import com.pagp.medicalweb.db.entity.laboratorio.MuestraEntity;
import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;
import com.pagp.medicalweb.db.mappers.LaboratorioDb;

@Repository
public class LaboratorioDao {

	@Autowired
	private LaboratorioDb laboratorioDb;

	public List<ConsultaEntity> obtenerConsultas(int idEntidad) {
		return laboratorioDb.obtenerConsultas(idEntidad);
	}

	public void crearAnalisis(AnalisisEntity analisisEntity) {
		laboratorioDb.crearAnalisis(analisisEntity);
	}

	public void crearMuestra(MuestraEntity muestraEntity) {
		laboratorioDb.crearMuestra(muestraEntity);
	}

}
