package com.pagp.medicalweb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.db.entity.administrador.CambiarPasswordEntity;
import com.pagp.medicalweb.db.entity.administrador.MiPerfilEntity;
import com.pagp.medicalweb.services.impl.MiPerfilServices;
import com.pagp.medicalweb.web.core.AuthenticationFacade;
import com.pagp.medicalweb.web.core.dto.AuthenticatedUser;

@RestController
@RequestMapping("/api/miperfil")
public class MiPerfilController {

	@Autowired
	private AuthenticationFacade authenticationFacade;

	@Autowired
	private MiPerfilServices miPerfilServices;

	@RequestMapping
	public MiPerfilEntity obtenerMiPerfil() {
		AuthenticatedUser user = authenticationFacade.getAuthentication();
		return miPerfilServices.obtenerPerfilUsuario(user);
	}

	@RequestMapping(value = "/cambiarPassword", method = RequestMethod.POST)
	public void cambiarPassword(CambiarPasswordEntity cambiarPasswordEntity) {
		AuthenticatedUser user = authenticationFacade.getAuthentication();
		cambiarPasswordEntity.setId_usuario(user.getId());
		miPerfilServices.cambiarPassword(cambiarPasswordEntity);
	}

}
