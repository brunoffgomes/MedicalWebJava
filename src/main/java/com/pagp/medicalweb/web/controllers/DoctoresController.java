package com.pagp.medicalweb.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.db.entity.DoctorEntity;
import com.pagp.medicalweb.services.impl.DoctoresServices;

@RestController
@RequestMapping("/doctores")
public class DoctoresController {

	@Autowired
	private DoctoresServices doctoresServices;

	@RequestMapping("/{idEntidad}")
	List<DoctorEntity> obtenerEntidades(@PathVariable int idEntidad) {
		return doctoresServices.obtenerDoctores(idEntidad);
	}

}
