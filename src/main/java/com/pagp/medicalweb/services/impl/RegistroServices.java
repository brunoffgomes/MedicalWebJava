package com.pagp.medicalweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagp.medicalweb.dao.UsuariosDao;
import com.pagp.medicalweb.db.entity.UsuarioEntity;
import com.pagp.medicalweb.web.dto.registro.AdministradorFormDto;

@Service
public class RegistroServices {
	
	@Autowired
	private UsuariosDao usuariosDao;

	public AdministradorFormDto crearAdministrador(AdministradorFormDto administradorFormDto){
		
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuariosDao.crearUsuario(usuarioEntity);
		
		return administradorFormDto;
	}
	
	
	public void crearClinica(){
		
	}	
}
