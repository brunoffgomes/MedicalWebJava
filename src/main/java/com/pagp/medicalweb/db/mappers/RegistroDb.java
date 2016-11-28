package com.pagp.medicalweb.db.mappers;

import com.pagp.medicalweb.db.entity.AdministradorEntity;
import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;

public interface RegistroDb {

	EntidadEntity insertEntidad(EntidadEntity entidadEntity);
	
	ModuloContratadoEntity agregarModuloEntidad(ModuloContratadoEntity mContratadoEntity);
	
	AdministradorEntity insertAdministrador(AdministradorEntity administradorEntity);
	
}
