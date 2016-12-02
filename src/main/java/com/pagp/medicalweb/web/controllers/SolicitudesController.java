package com.pagp.medicalweb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.services.impl.SolicitudesServices;
import com.pagp.medicalweb.web.dto.solicitud.DiagnosticoFormDto;
import com.pagp.medicalweb.web.dto.solicitud.RecetaFormDto;
import com.pagp.medicalweb.web.dto.solicitud.SolicitudFormDto;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudesController {

	@Autowired
	private SolicitudesServices solicitudesServices;

	@RequestMapping(value = "/crearSolicitud", method = RequestMethod.POST)
	public void crearSolicitud(@RequestBody SolicitudFormDto solicitudFormDto) {
		solicitudesServices.crearSolicitud(solicitudFormDto);
	}

	@RequestMapping(value = "/diagnostico", method = RequestMethod.POST)
	public void crearDiagnostico(@RequestBody DiagnosticoFormDto diagnosticoFormDto) {
		solicitudesServices.crearDiagnostico(diagnosticoFormDto);

	}

	@RequestMapping(value = "/crearReceta", method = RequestMethod.POST)
	public void crearReceta(@RequestBody RecetaFormDto recetaFormDto) {
		solicitudesServices.crearReceta(recetaFormDto);
	}

}
