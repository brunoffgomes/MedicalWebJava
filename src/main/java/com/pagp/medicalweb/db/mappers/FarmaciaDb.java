package com.pagp.medicalweb.db.mappers;

import java.util.List;

import com.pagp.medicalweb.db.entity.MedicamentoEntity;

public interface FarmaciaDb {

	List<MedicamentoEntity> getMedicamentosByEntidad(int idEntidad);
	
	void insertMedicamento(MedicamentoEntity MedicamentoEntity);
	
	void updateMedicamento(MedicamentoEntity idEntidad);

}
