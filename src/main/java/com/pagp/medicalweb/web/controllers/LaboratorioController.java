package com.pagp.medicalweb.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;
import com.pagp.medicalweb.services.impl.LaboratorioServices;
import com.pagp.medicalweb.web.core.dto.AuthenticatedUser;
import com.pagp.medicalweb.web.dto.laboratorio.AnalisisFormDto;

@RestController
@RequestMapping("/api/laboratorio")
public class LaboratorioController {

	@Autowired
	private LaboratorioServices laboratorioServices;

	// Mapeo de url GET "/api/laboratorio"
	@RequestMapping(method = RequestMethod.GET)
	List<ConsultaEntity> obtenerAnalisis() {
		AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return laboratorioServices.obtenerAnalisis(user.getIdEntidad());
	}

	// Mapeo de url POST "/api/laboratorio"
	@RequestMapping(method = RequestMethod.POST)
	void crearAnalisis(@RequestBody AnalisisFormDto analisisFormDto) {
		AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		analisisFormDto.setIdLaboratorista(user.getId());
		laboratorioServices.crearAnalisis(analisisFormDto);
	}

}
