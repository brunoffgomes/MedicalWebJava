package com.pagp.medicalweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.db.entity.UsuarioEntity;
import com.pagp.medicalweb.db.mappers.UsuariosDb;

@Service
@Transactional
public class UsuariosDaoImpl implements UsuariosDao {

	@Autowired
	private UsuariosDb usuariosDb;

	@Override
	public UsuarioEntity getUsuarioByEmail(String email) {
		return usuariosDb.getUsuarioByEmail(email);
	}
}
