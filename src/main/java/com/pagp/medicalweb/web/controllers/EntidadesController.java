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
import com.pagp.medicalweb.web.dto.administrador.DetalleModuloFormDto;

@RestController
@RequestMapping("/api/entidades")
public class EntidadesController {

	@Autowired
	private EntidadesServices entidadesServices;

	@PreAuthorize("hasRole('ADMINISTRADOR')")
	@RequestMapping("/{idAdministrador}")
	List<EntidadEntity> obtenerEntidades(@PathVariable int idAdministrador) {
		return entidadesServices.obtenerEntidades(idAdministrador);
	}

	@RequestMapping("/modulosContratados/{idEntidad}")
	List<DetalleModuloFormDto> obtenerModulosEntidadActuales(@PathVariable int idEntidad) {
		return entidadesServices.obtenerModulosEntidadActuales(idEntidad);
	}

	@PreAuthorize("hasRole('SUPERADMINISTRADOR')")
	@RequestMapping(method = RequestMethod.GET)
	public List<EntidadEntity> obtenerEntidades() {
		return entidadesServices.obtenerEntidades();
	}

}
