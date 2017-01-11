package com.pagp.medicalweb.db.mappers;

import java.util.List;

import com.pagp.medicalweb.db.entity.FarmacologoEntity;
import com.pagp.medicalweb.db.entity.MedicamentoEntity;

public interface FarmaciaDb {

	List<MedicamentoEntity> getMedicamentosByEntidad(int idEntidad);

	List<MedicamentoEntity> obtenerMedicamentosPorEntidadDisponibles(int idEntidad);

	void insertMedicamento(MedicamentoEntity MedicamentoEntity);

	void updateMedicamento(MedicamentoEntity idEntidad);

	MedicamentoEntity obtenerMedicamento(int idMedicamento);

	List<FarmacologoEntity> getFarmacologosByEntidad(int idEntidad);

}
