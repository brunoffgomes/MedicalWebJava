package com.pagp.medicalweb.db.mappers;

import com.pagp.medicalweb.db.entity.UsuarioEntity;

public interface UsuariosDb {

	public UsuarioEntity getUsuarioByEmail(String email);

	public void insertUser(UsuarioEntity usuarioEntity);

}
