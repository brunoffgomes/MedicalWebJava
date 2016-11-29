package com.pagp.medicalweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.FarmaciaDb;
import com.pagp.medicalweb.db.entity.MedicamentoEntity;

@Repository
public class FarmaciaDao {

	@Autowired
	private FarmaciaDb db;
	
	public List<MedicamentoEntity> obtenerMedicamentosPorEntidad(int idEntidad){
		return db.getMedicamentosByEntidad(idEntidad);
	}
	public MedicamentoEntity guardarMedicamento(MedicamentoEntity medicamentoEntity){
		 db.insertMedicamento(medicamentoEntity);
		 return medicamentoEntity;
	}
	public MedicamentoEntity actulizarMedicamento(MedicamentoEntity medicamentoEntity){
		 db.insertMedicamento(medicamentoEntity);
		 return medicamentoEntity;	
	}
}
