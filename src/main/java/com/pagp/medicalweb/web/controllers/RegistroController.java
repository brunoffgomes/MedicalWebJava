package com.pagp.medicalweb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.db.entity.receta.PacienteEntity;
import com.pagp.medicalweb.services.impl.RegistroServices;
import com.pagp.medicalweb.web.core.AuthenticationFacade;
import com.pagp.medicalweb.web.dto.core.UsuarioBaseFormDto;
import com.pagp.medicalweb.web.dto.registro.AdministradorCEFormDto;
import com.pagp.medicalweb.web.dto.registro.AdministradorFormDto;
import com.pagp.medicalweb.web.dto.registro.DoctorFormDto;
import com.pagp.medicalweb.web.dto.registro.EnfermeroFormDto;
import com.pagp.medicalweb.web.dto.registro.EntidadMedicaFormDto;
import com.pagp.medicalweb.web.dto.registro.FarmacologoFormDto;
import com.pagp.medicalweb.web.dto.registro.LaboratoristaFormDto;

@RestController
@RequestMapping("/api/registro")
public class RegistroController {

	@Autowired
	private RegistroServices registroServices;

	@Autowired
	public AuthenticationFacade authenticationFacade;

	@RequestMapping(value = "/registroAdministrador", method = RequestMethod.POST)
	public void registroAdministrador(@RequestBody AdministradorFormDto administradorFormDto) {
		administradorFormDto = registroServices.crearAdministrador(administradorFormDto);
	}

	@PreAuthorize("hasRole('SUPERADMINISTRADOR')")
	@RequestMapping(value = "/registroSuperAdministrador", method = RequestMethod.POST)
	public void registroSuperAdministrador(@RequestBody UsuarioBaseFormDto usuarioBaseFormDto) {
		registroServices.crearSuperAdministrador(usuarioBaseFormDto);
	}

	@PreAuthorize("hasRole('ADMINISTRADOR')")
	@RequestMapping(value = "/registroAdministradorCe", method = RequestMethod.POST)
	public void registroAdministradorCE(@RequestBody AdministradorCEFormDto administradorCEFormDto) {
		registroServices.crearAdministradorCE(administradorCEFormDto);
	}

	@PreAuthorize("hasRole('ADMINISTRADOR')")
	@RequestMapping(value = "/registroClinica", method = RequestMethod.POST)
	public EntidadMedicaFormDto registroClinica(@RequestBody EntidadMedicaFormDto entidadMedicaFormDto) {
		registroServices.crearClinica(entidadMedicaFormDto);
		return entidadMedicaFormDto;
	}

	@PreAuthorize("hasRole('ENFERMERO')")
	@RequestMapping(value = "/registroPaciente", method = RequestMethod.POST)
	public PacienteEntity registroPaciente(@RequestBody PacienteEntity pacienteEntity) {
		registroServices.crearPaciente(pacienteEntity);
		return pacienteEntity;
	}

	@PreAuthorize("hasRole('ADMINISTRADOR_CE')")
	@RequestMapping(value = "/registroDoctor", method = RequestMethod.POST)
	public void registroDoctor(@RequestBody DoctorFormDto doctorFormDto) {
		registroServices.crearDoctor(doctorFormDto);
	}

	@PreAuthorize("hasRole('ADMINISTRADOR_CE')")
	@RequestMapping(value = "/registroEnfermero", method = RequestMethod.POST)
	public void registroEnfermero(@RequestBody EnfermeroFormDto enfermeroFormDto) {
		registroServices.crearEnfermero(enfermeroFormDto);
	}

	@PreAuthorize("hasRole('ADMINISTRADOR_CE')")
	@RequestMapping(value = "/registroFarmacologo", method = RequestMethod.POST)
	public void registroFarmacologo(@RequestBody FarmacologoFormDto farmacologoFormDto) {
		registroServices.crearFarmacologo(farmacologoFormDto);
	}

	@PreAuthorize("hasRole('ADMINISTRADOR_CE')")
	@RequestMapping(value = "/registroLaboratorista", method = RequestMethod.POST)
	public void registroFarmacologo(@RequestBody LaboratoristaFormDto laboratoristaFormDto) {
		registroServices.crearLaboratorista(laboratoristaFormDto);
	}

	@RequestMapping(value = "/valid/email", method = RequestMethod.GET)
	public Boolean validEmail(@RequestParam("email") String email) {
		return registroServices.validEmail(email);
	}

}
