package com.pagp.medicalweb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.services.impl.RegistroServices;
import com.pagp.medicalweb.web.dto.registro.AdministradorFormDto;
import com.pagp.medicalweb.web.dto.registro.EntidadMedicaFormDto;

@RestController
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private RegistroServices registroServices;

	@RequestMapping(value = "/registroAdministrador", method = RequestMethod.POST)
	public AdministradorFormDto registroAdministrador(@RequestBody AdministradorFormDto administradorFormDto) {
		administradorFormDto = registroServices.crearAdministrador(administradorFormDto);
		return administradorFormDto;
	}

	@RequestMapping(value = "/registroClinica", method = RequestMethod.POST)
	public EntidadMedicaFormDto registroClinica(@RequestBody EntidadMedicaFormDto entidadMedicaFormDto) {
		registroServices.crearClinica(entidadMedicaFormDto);
		return entidadMedicaFormDto;
	}

	@RequestMapping(value = "/valid/email", method = RequestMethod.GET)
	public Boolean registroClinica(@RequestParam("email") String email) {
		return registroServices.validEmail(email);
	}

}
