package com.pagp.medicalweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.MedicamentoEntity;
import com.pagp.medicalweb.db.mappers.FarmaciaDb;

@Repository
public class FarmaciaDao {

	@Autowired
	private FarmaciaDb db;

	public List<MedicamentoEntity> obtenerMedicamentosPorEntidad(int idEntidad) {
		return db.getMedicamentosByEntidad(idEntidad);
	}

	public List<MedicamentoEntity> obtenerMedicamentosPorEntidadDisponibles(int idEntidad) {
		return db.obtenerMedicamentosPorEntidadDisponibles(idEntidad);
	}

	public MedicamentoEntity guardarMedicamento(MedicamentoEntity medicamentoEntity) {
		db.insertMedicamento(medicamentoEntity);
		return medicamentoEntity;
	}

	public MedicamentoEntity actulizarMedicamento(MedicamentoEntity medicamentoEntity) {
		db.updateMedicamento(medicamentoEntity);
		return medicamentoEntity;
	}
}
