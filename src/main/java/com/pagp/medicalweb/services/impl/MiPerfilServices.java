package com.pagp.medicalweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagp.medicalweb.dao.EntidadesDao;
import com.pagp.medicalweb.dao.MiPerfilDao;
import com.pagp.medicalweb.db.entity.administrador.CambiarPasswordEntity;
import com.pagp.medicalweb.db.entity.administrador.MiPerfilEntity;
import com.pagp.medicalweb.services.exceptions.UserDataException;
import com.pagp.medicalweb.web.core.dto.AuthenticatedUser;

@Service
public class MiPerfilServices {

	@Autowired
	private MiPerfilDao miPerfilDao;

	@Autowired
	private EntidadesDao entidadesDao;

	public MiPerfilEntity obtenerPerfilUsuario(AuthenticatedUser usuario) {
		MiPerfilEntity miPerfilEntity = miPerfilDao.obtenerPerfilUsuario(usuario.getId());
		if (usuario.getIdEntidad() != null) {
			miPerfilEntity.setEntidad(entidadesDao.obtenerEntidad(usuario.getIdEntidad()));

		}
		return miPerfilEntity;
	}

	public void cambiarPassword(CambiarPasswordEntity cambiarPasswordEntity) {
		int rowChanges = miPerfilDao.cambiarPassword(cambiarPasswordEntity);
		if (rowChanges == 0) {
			throw new UserDataException("El password actual no es correcto");
		}
	}

}
