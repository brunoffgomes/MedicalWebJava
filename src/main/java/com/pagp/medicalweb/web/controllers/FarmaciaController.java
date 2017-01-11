package com.pagp.medicalweb.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.db.entity.FarmacologoEntity;
import com.pagp.medicalweb.db.entity.MedicamentoEntity;
import com.pagp.medicalweb.services.impl.FarmaciaServices;
import com.pagp.medicalweb.web.core.AuthenticationFacade;
import com.pagp.medicalweb.web.core.dto.AuthenticatedUser;

@RestController
@RequestMapping("/api/farmacia")
public class FarmaciaController {

	@Autowired
	private FarmaciaServices farmaciaServices;

	@Autowired
	public AuthenticationFacade authenticationFacade;

	/*
	 * Obtener medicamentos GET /api/farmacia/medicamentos
	 */
	@PreAuthorize("hasRole('FARMACIA')")
	@RequestMapping(value = "/medicamentos", method = RequestMethod.GET)
	public List<MedicamentoEntity> obtenerMedicamentosPorEntidad() {
		AuthenticatedUser usuario = authenticationFacade.getAuthentication();
		return farmaciaServices.obtenerMedicamentosPorEntidad(usuario.getIdEntidad());
	}

	/*
	 * Obtener medicamentos para modulo crear receta GET
	 * /api/farmacia/medicamentos/disponibles
	 */
	@RequestMapping(value = "/medicamentos/disponibles", method = RequestMethod.GET)
	public List<MedicamentoEntity> obtenerMedicamentosPorEntidadDisponibles() {
		AuthenticatedUser usuario = authenticationFacade.getAuthentication();
		return farmaciaServices.obtenerMedicamentosPorEntidadDisponibles(usuario.getIdEntidad());
	}

	/*
	 * Guardar nuevo medicamento POST /api/farmacia
	 */
	@PreAuthorize("hasRole('FARMACIA')")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public MedicamentoEntity guardarMedicamento(@RequestBody MedicamentoEntity medicamentoEntity) {
		return farmaciaServices.guardarMedicamento(medicamentoEntity);
	}

	/*
	 * Actualizar medicamento PUT /api/farmacia
	 */
	@PreAuthorize("hasRole('FARMACIA')")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public MedicamentoEntity actualizarMedicamento(@RequestBody MedicamentoEntity medicamentoEntity) {
		return farmaciaServices.actulizarMedicamento(medicamentoEntity);
	}

	/*
	 * Obtener los farmacologos de una entidad GET /api/farmacia/farmacologos
	 */
	@PreAuthorize("hasRole('ADMINISTRADOR_CE')")
	@RequestMapping("/farmacologos")
	public List<FarmacologoEntity> obtenerFarmacologos() {
		AuthenticatedUser usuario = authenticationFacade.getAuthentication();
		return farmaciaServices.obtenerFarmacologosByEntidad(usuario.getIdEntidad());
	}
}
