package com.pagp.medicalweb.db.entity;

import java.util.List;

public interface FarmaciaDb {

	List<MedicamentoEntity> getMedicamentosByEntidad(int idEntidad);
	
	void insertMedicamento(MedicamentoEntity MedicamentoEntity);
	
	void updateMedicamento(MedicamentoEntity idEntidad);

}
