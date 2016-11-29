package com.pagp.medicalweb.db.mappers;

import com.pagp.medicalweb.db.entity.AdministradorEntity;
import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;

public interface RegistroDb {

	void insertEntidad(EntidadEntity entidadEntity);

	void agregarModuloEntidad(ModuloContratadoEntity mContratadoEntity);

	void insertAdministrador(AdministradorEntity administradorEntity);

}
