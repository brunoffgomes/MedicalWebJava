package com.pagp.medicalweb.db.mappers;

import java.util.List;

import com.pagp.medicalweb.db.entity.laboratorio.AnalisisEntity;
import com.pagp.medicalweb.db.entity.laboratorio.EvidenciaEntity;
import com.pagp.medicalweb.db.entity.laboratorio.MuestraEntity;
import com.pagp.medicalweb.db.entity.laboratorio.ResultadoEntity;
import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;

public interface LaboratorioDb {

	List<ConsultaEntity> obtenerAnalisis(int idEntidad);

	void crearAnalisis(AnalisisEntity analisisEntity);

	void crearMuestra(MuestraEntity muestraEntity);

	List<ConsultaEntity> registrosResultados(int idEntidad);

	void crearResultado(ResultadoEntity resultadoEntity);

	void crearEvidencia(EvidenciaEntity evidenciaEntity);

	void actualizarAnalisis(AnalisisEntity analisisEntity);

	AnalisisEntity obtenerAnalisisPorId(int idAnalisis);

}
