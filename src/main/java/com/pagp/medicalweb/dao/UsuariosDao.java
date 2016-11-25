package com.pagp.medicalweb.dao;

import com.pagp.medicalweb.db.entity.UsuarioEntity;

public interface UsuariosDao {

	UsuarioEntity getUsuarioByEmail(String email);

}
