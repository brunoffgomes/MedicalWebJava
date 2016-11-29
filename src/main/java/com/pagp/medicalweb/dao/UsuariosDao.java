package com.pagp.medicalweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.UsuarioEntity;
import com.pagp.medicalweb.db.mappers.UsuariosDb;

@Repository
public class UsuariosDao {

	@Autowired
	private UsuariosDb usuariosDb;

	public UsuarioEntity getUsuarioByEmail(String email) {
		return usuariosDb.getUsuarioByEmail(email);
	}

	public UsuarioEntity crearUsuario(UsuarioEntity usuarioEntity) {
		usuariosDb.insertUser(usuarioEntity);
		return usuarioEntity;
	}

}