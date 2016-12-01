package com.pagp.medicalweb.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.db.entity.receta.PacienteEntity;
import com.pagp.medicalweb.services.impl.PacientesServices;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

	@Autowired
	private PacientesServices pacientesServices;

	@RequestMapping("/{idEntidad}")
	List<PacienteEntity> obtenerEntidades(@PathVariable int idEntidad) {
		return pacientesServices.obtenerPacientes(idEntidad);
	}

}
