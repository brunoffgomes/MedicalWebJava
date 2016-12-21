package com.pagp.medicalweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.administrador.CambiarPasswordEntity;
import com.pagp.medicalweb.db.entity.administrador.MiPerfilEntity;
import com.pagp.medicalweb.db.mappers.MiPerfilDb;

@Repository
public class MiPerfilDao {

	@Autowired
	private MiPerfilDb db;

	public MiPerfilEntity obtenerPerfilUsuario(int idUsuario) {
		return db.obtenerPerfilUsuario(idUsuario);
	}

	public void cambiarPassword(CambiarPasswordEntity cambiarPasswordEntity) {
		db.cambiarPassword(cambiarPasswordEntity);
	}

}
