package com.pagp.medicalweb.db.mappers;

import java.util.List;

import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;
import com.pagp.medicalweb.db.entity.receta.DiagnosticoEntity;
import com.pagp.medicalweb.db.entity.receta.MedicamentoRecetaEntity;
import com.pagp.medicalweb.db.entity.receta.RecetaEntity;
import com.pagp.medicalweb.db.entity.receta.SolicitudEntity;

public interface EntidadDb {

	List<EntidadEntity> obtenerEntidades(int idAdministrador);

	List<ModuloContratadoEntity> obtenerModulosEntidadActuales(int idEntidad);

	void crearSolicitud(SolicitudEntity solicitudEntity);

	void crearDiagnostico(DiagnosticoEntity diagnosticoEntity);

	void crearReceta(RecetaEntity recetaEntity);

	void crearMedicamentoReceta(MedicamentoRecetaEntity medicamentoRecetaEntity);

}
