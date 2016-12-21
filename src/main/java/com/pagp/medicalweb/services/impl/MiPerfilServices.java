package com.pagp.medicalweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagp.medicalweb.dao.MiPerfilDao;
import com.pagp.medicalweb.db.entity.administrador.CambiarPasswordEntity;
import com.pagp.medicalweb.db.entity.administrador.MiPerfilEntity;

@Service
public class MiPerfilServices {

	@Autowired
	private MiPerfilDao miPerfilDao;

	public MiPerfilEntity obtenerPerfilUsuario(int idUsuario) {
		return miPerfilDao.obtenerPerfilUsuario(idUsuario);
	}

	public void cambiarPassword(CambiarPasswordEntity cambiarPasswordEntity) {
		miPerfilDao.cambiarPassword(cambiarPasswordEntity);
	}

}
