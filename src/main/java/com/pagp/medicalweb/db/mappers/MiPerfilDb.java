package com.pagp.medicalweb.db.mappers;

import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.administrador.CambiarPasswordEntity;
import com.pagp.medicalweb.db.entity.administrador.MiPerfilEntity;

public interface MiPerfilDb {

	MiPerfilEntity obtenerPerfilUsuario(int idUsuario);

	EntidadEntity obtenerEntidad(int idEntidad);

	void cambiarPassword(CambiarPasswordEntity cambiarPasswordFormDto);

}
