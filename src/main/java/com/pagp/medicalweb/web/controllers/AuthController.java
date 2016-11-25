package com.pagp.medicalweb.web.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.dao.UsuariosDao;
import com.pagp.medicalweb.db.entity.UsuarioEntity;
import com.pagp.medicalweb.web.dto.UserLogginFormInDto;
import com.pagp.medicalweb.web.dto.UserLogginFormOutDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UsuariosDao usuariosDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserLogginFormOutDto loggin(UserLogginFormInDto user) {
		UserLogginFormOutDto result = new UserLogginFormOutDto();
		result.setExpires(new Date());
		result.setToken("llave de entrada");
		result.setTipoUsuario("algun tipo");
		return result;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public UsuarioEntity loggin() {
		return usuariosDao.getUsuarioByEmail("ricrrojas@gmail.com");
	}

	@RequestMapping(value = "/secure/user", method = RequestMethod.GET)
	public UsuarioEntity secure() {
		return usuariosDao.getUsuarioByEmail("ricrrojas@gmail.com");
	}

}
