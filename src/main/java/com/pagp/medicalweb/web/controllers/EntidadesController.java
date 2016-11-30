package com.pagp.medicalweb.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;
import com.pagp.medicalweb.services.impl.EntidadesServices;

@RestController
@RequestMapping("/entidades")
public class EntidadesController {

	@Autowired
	private EntidadesServices entidadesServices;

	@RequestMapping("/{idAdministrador}")
	List<EntidadEntity> obtenerEntidades(@PathVariable int idAdministrador) {
		return entidadesServices.obtenerEntidades(idAdministrador);
	}

	@RequestMapping("/modulosContratados/{idEntidad}")
	List<ModuloContratadoEntity> obtenerModulosEntidadActuales(@PathVariable int idEntidad) {
		return entidadesServices.obtenerModulosEntidadActuales(idEntidad);
	}

}
