package com.pagp.medicalweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.FarmaciaDao;
import com.pagp.medicalweb.db.entity.MedicamentoEntity;

@Service
@Transactional
public class FarmaciaServices {

	@Autowired
	private FarmaciaDao farmaciaDao;

	public List<MedicamentoEntity> obtenerMedicamentosPorEntidad(int idEntidad) {
		return farmaciaDao.obtenerMedicamentosPorEntidad(idEntidad);
	}

	public List<MedicamentoEntity> obtenerMedicamentosPorEntidadDisponibles(int idEntidad) {
		return farmaciaDao.obtenerMedicamentosPorEntidadDisponibles(idEntidad);
	}

	public MedicamentoEntity guardarMedicamento(MedicamentoEntity medicamentoEntity) {
		farmaciaDao.guardarMedicamento(medicamentoEntity);
		return medicamentoEntity;
	}

	public MedicamentoEntity actulizarMedicamento(MedicamentoEntity medicamentoEntity) {
		farmaciaDao.actulizarMedicamento(medicamentoEntity);
		return medicamentoEntity;
	}

}
