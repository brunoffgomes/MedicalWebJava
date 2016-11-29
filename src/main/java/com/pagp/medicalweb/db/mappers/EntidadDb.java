package com.pagp.medicalweb.db.mappers;

import java.util.List;

import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;

public interface EntidadDb {

	List<EntidadEntity> obtenerEntidades(int idAdministrador);

	List<ModuloContratadoEntity> obtenerModulosEntidadActuales(int idEntidad);

}
