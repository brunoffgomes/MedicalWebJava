package com.pagp.medicalweb.web.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.web.dto.registro.AdministradorFormDto;
import com.pagp.medicalweb.web.dto.registro.EntidadMedicaFormDto;

@RestController
@RequestMapping("/registro")
public class RegistroController {
	
	@RequestMapping(value = "/registroAdministrador",method = RequestMethod.POST)
	public AdministradorFormDto registroAdministrador(@RequestBody AdministradorFormDto administradorFormDto){
		return administradorFormDto;
	}
	
	@RequestMapping(value = "/registroClinica",method = RequestMethod.POST)
	public EntidadMedicaFormDto registroClinica(@RequestBody EntidadMedicaFormDto entidadMedicaFormDto){
		return entidadMedicaFormDto;
	}
	

}
