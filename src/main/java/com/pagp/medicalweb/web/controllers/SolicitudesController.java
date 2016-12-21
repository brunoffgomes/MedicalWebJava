package com.pagp.medicalweb.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.db.entity.receta.RecetaEntity;
import com.pagp.medicalweb.services.impl.SolicitudesServices;
import com.pagp.medicalweb.web.core.AuthenticationFacade;
import com.pagp.medicalweb.web.core.dto.AuthenticatedUser;
import com.pagp.medicalweb.web.dto.solicitud.DiagnosticoFormDto;
import com.pagp.medicalweb.web.dto.solicitud.RecetaFormDto;
import com.pagp.medicalweb.web.dto.solicitud.SolicitudFormDto;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudesController {

	@Autowired
	private SolicitudesServices solicitudesServices;

	@Autowired
	public AuthenticationFacade authenticationFacade;

	@PreAuthorize("hasRole('DOCTOR')")
	@RequestMapping(value = "/crearSolicitud", method = RequestMethod.POST)
	public void crearSolicitud(@RequestBody SolicitudFormDto solicitudFormDto) {
		solicitudesServices.crearSolicitud(solicitudFormDto);
	}

	@PreAuthorize("hasRole('DOCTOR')")
	@RequestMapping(value = "/diagnostico", method = RequestMethod.POST)
	public void crearDiagnostico(@RequestBody DiagnosticoFormDto diagnosticoFormDto) {
		solicitudesServices.crearDiagnostico(diagnosticoFormDto);
	}

	@PreAuthorize("hasRole('DOCTOR')")
	@RequestMapping(value = "/receta", method = RequestMethod.POST)
	public void crearReceta(@RequestBody RecetaFormDto recetaFormDto) {
		solicitudesServices.crearReceta(recetaFormDto);
	}

	@PreAuthorize("hasRole('FARMACIA')")
	@RequestMapping(value = "/recetas", method = RequestMethod.GET)
	public List<RecetaEntity> obtenerRecetas() {
		AuthenticatedUser usuario = authenticationFacade.getAuthentication();
		return solicitudesServices.obtenerRecetas(usuario.getIdEntidad());
	}

	@PreAuthorize("hasRole('FARMACIA')")
	@RequestMapping(value = "/recetas/{idReceta}", method = RequestMethod.GET)
	public RecetaEntity obtenerReceta(@PathVariable int idReceta) {
		return solicitudesServices.obtenerReceta(idReceta);
	}

	@PreAuthorize("hasRole('FARMACIA')")
	@RequestMapping(value = "/recetas/entrega", method = RequestMethod.POST)
	public void obtenerReceta(@RequestBody RecetaEntity recetaEntity) {
		solicitudesServices.entregarReceta(recetaEntity);
	}

}
