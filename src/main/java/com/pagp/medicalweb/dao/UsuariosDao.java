package com.pagp.medicalweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.db.entity.UsuarioEntity;
import com.pagp.medicalweb.db.mappers.UsuariosDb;

@Service
@Transactional
public class UsuariosDao { 
	@Autowired
	private UsuariosDb usuariosDb;
	
	public UsuarioEntity getUsuarioByEmail(String email) {
		return usuariosDb.getUsuarioByEmail(email);
	}
	
	public UsuarioEntity crearUsuario(UsuarioEntity usuarioEntity) {
		return usuariosDb.insertUser(usuarioEntity);
	}

}