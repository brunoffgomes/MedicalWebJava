package com.pagp.medicalweb.web.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.db.entity.DoctorEntity;
import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;
import com.pagp.medicalweb.db.entity.receta.DiagnosticoEntity;
import com.pagp.medicalweb.services.impl.DoctoresServices;
import com.pagp.medicalweb.web.core.dto.AuthenticatedUser;

@RestController
@RequestMapping("/doctores")
public class DoctoresController {

	private Logger logger = LoggerFactory.getLogger(DoctoresController.class);

	@Autowired
	private DoctoresServices doctoresServices;

	@RequestMapping("/{idEntidad}")
	List<DoctorEntity> obtenerDoctores(@PathVariable int idEntidad) {
		return doctoresServices.obtenerDoctores(idEntidad);
	}

	@RequestMapping("/obtenerConsultas/{idEntidad}")
	List<ConsultaEntity> obtenerConsultas(@PathVariable int idEntidad) {
		AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return doctoresServices.obtenerConsultas(user.getIdEntidad());
	}

	@RequestMapping("/consulta/{idSolicitud}")
	ConsultaEntity obtenerConsulta(@PathVariable int idSolicitud) {
		return doctoresServices.obtenerConsulta(idSolicitud);
	}

	@RequestMapping("/diagnosticos")
	List<DiagnosticoEntity> diagnosticos() {
		AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return doctoresServices.obtenerDiagnosticos(user.getId());
	}

	@RequestMapping("/diagnosticos/{idDiagnostico}")
	DiagnosticoEntity diagnosticos(@PathVariable int idDiagnostico) {
		return doctoresServices.obtenerDiagnostico(idDiagnostico);
	}

}
