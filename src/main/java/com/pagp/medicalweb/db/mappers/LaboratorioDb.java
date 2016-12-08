package com.pagp.medicalweb.db.mappers;

import java.util.List;

import com.pagp.medicalweb.db.entity.laboratorio.AnalisisEntity;
import com.pagp.medicalweb.db.entity.laboratorio.MuestraEntity;
import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;

public interface LaboratorioDb {

	List<ConsultaEntity> obtenerConsultas(int idEntidad);

	void crearAnalisis(AnalisisEntity analisisEntity);

	void crearMuestra(MuestraEntity muestraEntity);
}
