package com.pagp.medicalweb.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.db.entity.receta.PacienteEntity;
import com.pagp.medicalweb.services.impl.PacientesServices;
import com.pagp.medicalweb.web.core.AuthenticationFacade;
import com.pagp.medicalweb.web.core.dto.AuthenticatedUser;

@RestController
@RequestMapping("/api/pacientes")
public class PacientesController {

	@Autowired
	private PacientesServices pacientesServices;

	@Autowired
	public AuthenticationFacade authenticationFacade;

	@PreAuthorize("hasRole('ENFERMERO')")
	@RequestMapping("")
	List<PacienteEntity> getPacientes() {
		AuthenticatedUser usuario = authenticationFacade.getAuthentication();
		return pacientesServices.obtenerPacientes(usuario.getIdEntidad());
	}

	@PreAuthorize("hasRole('ENFERMERO')")
	@RequestMapping("/{idPaciente}")
	PacienteEntity getPaciente(@PathVariable int idPaciente) {
		return pacientesServices.obtenerPaciente(idPaciente);
	}

}
