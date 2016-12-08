package com.pagp.medicalweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.auditoria.RegistroEntity;
import com.pagp.medicalweb.db.mappers.AuditoriaDb;

@Repository
public class AuditoriaDao {

	@Autowired
	private AuditoriaDb auditoriaDb;

	public void crearRegistro(RegistroEntity registroEntity) {
		auditoriaDb.crearRegistro(registroEntity);
	}
}
