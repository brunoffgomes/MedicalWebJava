package com.pagp.medicalweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.LaboratoristaEntity;
import com.pagp.medicalweb.db.entity.laboratorio.AnalisisEntity;
import com.pagp.medicalweb.db.entity.laboratorio.EvidenciaEntity;
import com.pagp.medicalweb.db.entity.laboratorio.MuestraEntity;
import com.pagp.medicalweb.db.entity.laboratorio.ResultadoEntity;
import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;
import com.pagp.medicalweb.db.mappers.LaboratorioDb;

@Repository
public class LaboratorioDao {

	@Autowired
	private LaboratorioDb laboratorioDb;

	public List<ConsultaEntity> obtenerConsultas(int idEntidad) {
		return laboratorioDb.obtenerAnalisis(idEntidad);
	}

	public void crearAnalisis(AnalisisEntity analisisEntity) {
		laboratorioDb.crearAnalisis(analisisEntity);
	}

	public void crearMuestra(MuestraEntity muestraEntity) {
		laboratorioDb.crearMuestra(muestraEntity);
	}

	public List<ConsultaEntity> registrosResultados(int idEntidad) {
		return laboratorioDb.registrosResultados(idEntidad);
	}

	public void crearResultado(ResultadoEntity resultadoEntity) {
		laboratorioDb.crearResultado(resultadoEntity);
	}

	public void crearEvidencia(EvidenciaEntity evidenciaEntity) {
		laboratorioDb.crearEvidencia(evidenciaEntity);
	}

	public void actualizarAnalisis(AnalisisEntity analisisEntity) {
		laboratorioDb.actualizarAnalisis(analisisEntity);
	}

	public AnalisisEntity actualizarAnalisis(int idAnalisis) {
		return laboratorioDb.obtenerAnalisisPorId(idAnalisis);
	}

	public AnalisisEntity obtenerAnalisisPorId(int idAnalisis) {
		return laboratorioDb.obtenerAnalisisPorId(idAnalisis);
	}
	
	public List<LaboratoristaEntity> obtenerLaboratorista(int idEntidad){
		return laboratorioDb.getLaboratoristasByEntidad(idEntidad);
	}

}
