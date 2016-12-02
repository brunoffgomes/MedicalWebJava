package com.pagp.medicalweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.receta.DiagnosticoEntity;
import com.pagp.medicalweb.db.entity.receta.MedicamentoRecetaEntity;
import com.pagp.medicalweb.db.entity.receta.RecetaEntity;
import com.pagp.medicalweb.db.entity.receta.SolicitudEntity;
import com.pagp.medicalweb.db.mappers.EntidadDb;

@Repository
public class SolicitudesDao {

	@Autowired
	private EntidadDb entidadDb;

	public SolicitudEntity crearSolicitud(SolicitudEntity solicitudEntity) {
		entidadDb.crearSolicitud(solicitudEntity);
		return solicitudEntity;
	}

	public DiagnosticoEntity crearDiagnostico(DiagnosticoEntity diagnosticoEntity) {
		entidadDb.crearDiagnostico(diagnosticoEntity);
		return diagnosticoEntity;
	}

	public RecetaEntity crearReceta(RecetaEntity recetaEntity) {
		entidadDb.crearReceta(recetaEntity);
		return recetaEntity;
	}

	public MedicamentoRecetaEntity crearMedicamentoReceta(MedicamentoRecetaEntity medicamentoRecetaEntity) {
		entidadDb.crearMedicamentoReceta(medicamentoRecetaEntity);
		return medicamentoRecetaEntity;
	}

}
