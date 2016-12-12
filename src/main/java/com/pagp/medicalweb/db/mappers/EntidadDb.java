package com.pagp.medicalweb.db.mappers;

import java.util.List;

import com.pagp.medicalweb.db.entity.AdministradorCEEntity;
import com.pagp.medicalweb.db.entity.EnfermeroEntity;
import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.FarmacologoEntity;
import com.pagp.medicalweb.db.entity.LaboratoristaEntity;
import com.pagp.medicalweb.db.entity.administrador.DetalleModuloEntity;
import com.pagp.medicalweb.db.entity.receta.DiagnosticoEntity;
import com.pagp.medicalweb.db.entity.receta.MedicamentoRecetaEntity;
import com.pagp.medicalweb.db.entity.receta.RecetaEntity;
import com.pagp.medicalweb.db.entity.receta.SolicitudEntity;

public interface EntidadDb {

	List<EntidadEntity> obtenerEntidades(int idAdministrador);

	List<EntidadEntity> obtenerEntidadesAll();

	List<DetalleModuloEntity> obtenerModulosEntidadActuales(int idEntidad);

	List<DetalleModuloEntity> obtenerModulosEntidadActivos(int idEntidad);

	void crearSolicitud(SolicitudEntity solicitudEntity);

	void crearDiagnostico(DiagnosticoEntity diagnosticoEntity);

	void crearReceta(RecetaEntity recetaEntity);

	void crearMedicamentoReceta(MedicamentoRecetaEntity medicamentoRecetaEntity);

	void actualizarSolicitud(SolicitudEntity solicitudEntity);

	void actualizarDiagnostico(DiagnosticoEntity diagnosticoEntity);

	void actualizarReceta(RecetaEntity recetaEntity);

	EnfermeroEntity getEnfermero(int idEnfermero);

	FarmacologoEntity getFarmacologo(int idFarmacologoo);

	AdministradorCEEntity getAdministradorCE(int idAdministradorCE);

	LaboratoristaEntity getLaboratorista(int idLaboratorista);

	List<RecetaEntity> getRecetas(int idEntidad);

	RecetaEntity getReceta(int idReceta);

}
