package com.pagp.medicalweb.db.mappers;

import com.pagp.medicalweb.db.entity.administrador.CambiarPasswordEntity;
import com.pagp.medicalweb.db.entity.administrador.MiPerfilEntity;

public interface MiPerfilDb {

	MiPerfilEntity obtenerPerfilUsuario(int idUsuario);

	void cambiarPassword(CambiarPasswordEntity cambiarPasswordFormDto);

}
