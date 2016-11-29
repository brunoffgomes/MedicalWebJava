package com.pagp.medicalweb.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.db.entity.MedicamentoEntity;
import com.pagp.medicalweb.services.impl.FarmaciaServices;

@RestController()
@RequestMapping("/farmacia")
public class FarmaciaController {

	@Autowired
	private FarmaciaServices farmaciaServices;

	@RequestMapping(value = "/medicamentos/{idEntidad}", method = RequestMethod.GET)
	public List<MedicamentoEntity> obtenerMedicamentosPorEntidad(@PathVariable int idEntidad) {
		return farmaciaServices.obtenerMedicamentosPorEntidad(idEntidad);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public MedicamentoEntity guardarMedicamento(@RequestBody MedicamentoEntity medicamentoEntity) {
		return farmaciaServices.guardarMedicamento(medicamentoEntity);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public MedicamentoEntity actulizarMedicamento(@RequestBody MedicamentoEntity medicamentoEntity) {
		return farmaciaServices.actulizarMedicamento(medicamentoEntity);
	}
}
