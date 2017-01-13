package com.pagp.medicalweb.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pagp.medicalweb.db.entity.LaboratoristaEntity;
import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;
import com.pagp.medicalweb.services.impl.LaboratorioServices;
import com.pagp.medicalweb.web.core.AuthenticationFacade;
import com.pagp.medicalweb.web.core.ResultadoFormDtoDataBinder;
import com.pagp.medicalweb.web.core.dto.AuthenticatedUser;
import com.pagp.medicalweb.web.dto.laboratorio.AnalisisFormDto;
import com.pagp.medicalweb.web.dto.laboratorio.ResultadoFormDto;

@Controller
@RequestMapping("/api/laboratorio")
public class LaboratorioController {

	@Autowired
	private LaboratorioServices laboratorioServices;

	@Autowired
	private AuthenticationFacade authenticationFacade;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(ResultadoFormDto.class, new ResultadoFormDtoDataBinder());
	}
	
	@RequestMapping("/laboratoristas")
	@ResponseBody
	public List<LaboratoristaEntity> obtenerLaboratorista(){
		AuthenticatedUser user = authenticationFacade.getAuthentication();
		return laboratorioServices.obtenerLaboratorista(user.getIdEntidad());
	}

	// Mapeo de url GET "/api/laboratorio"
	@PreAuthorize("hasRole('LABORATORIO')")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	List<ConsultaEntity> obtenerAnalisis() {
		AuthenticatedUser user = authenticationFacade.getAuthentication();
		return laboratorioServices.obtenerAnalisis(user.getIdEntidad());
	}

	// Mapeo de url POST "/api/laboratorio"
	@PreAuthorize("hasRole('LABORATORIO')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	void crearAnalisis(@RequestBody AnalisisFormDto analisisFormDto) {
		AuthenticatedUser user = authenticationFacade.getAuthentication();
		analisisFormDto.setIdLaboratorista(user.getId());
		laboratorioServices.crearAnalisis(analisisFormDto);
	}

	// Mapeo de url GET "/api/laboratorio"
	@PreAuthorize("hasRole('LABORATORIO')")
	@RequestMapping(value = "/resultadosPendiente", method = RequestMethod.GET)
	@ResponseBody
	List<ConsultaEntity> resultadosPendiente() {
		AuthenticatedUser user = authenticationFacade.getAuthentication();
		return laboratorioServices.registrosResultados(user.getIdEntidad());
	}

	@PreAuthorize("hasRole('LABORATORIO')")
	@RequestMapping(value = "/resultadosPendiente", method = RequestMethod.POST)
	@ResponseBody
	void resultadosPendiente(@RequestPart("files") MultipartFile[] files,
			@RequestParam("model") ResultadoFormDto resultado, HttpServletRequest request) {
		laboratorioServices.crearResultado(files, resultado);
	}

	
}
