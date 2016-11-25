package com.pagp.medicalweb.db.mappers;

import com.pagp.medicalweb.db.entity.UsuarioEntity;

public interface UsuariosDb {

	UsuarioEntity getUsuarioByEmail(String email);
}
