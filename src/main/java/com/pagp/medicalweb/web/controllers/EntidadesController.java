package com.pagp.medicalweb.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.services.impl.EntidadesServices;
import com.pagp.medicalweb.web.core.AuthenticationFacade;
import com.pagp.medicalweb.web.core.dto.AuthenticatedUser;
import com.pagp.medicalweb.web.dto.administrador.DetalleModuloFormDto;

@RestController
@RequestMapping("/api/entidades")
public class EntidadesController {

	@Autowired
	private EntidadesServices entidadesServices;

	@Autowired
	private AuthenticationFacade authenticationFacade;

	@PreAuthorize("hasRole('ADMINISTRADOR')")
	@RequestMapping("/administrador")
	List<EntidadEntity> obtenerEntidades(@PathVariable int idAdministrador) {
		AuthenticatedUser user = authenticationFacade.getAuthentication();
		return entidadesServices.obtenerEntidades(user.getId());
	}

	@RequestMapping("/modulosContratados/{idEntidad}")
	List<DetalleModuloFormDto> obtenerModulosEntidadActuales(@PathVariable int idEntidad) {
		return entidadesServices.obtenerModulosEntidadActuales(idEntidad);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<EntidadEntity> obtenerEntidades() {
		return entidadesServices.obtenerEntidades();
	}

}
