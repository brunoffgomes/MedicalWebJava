package com.pagp.medicalweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.AdministradorEntity;
import com.pagp.medicalweb.db.mappers.RegistroDb;

@Repository
public class RegistroDao {

	@Autowired
	private RegistroDb registroDb;

	public AdministradorEntity guardarAdministrador(AdministradorEntity administradorEntity) {
		registroDb.insertAdministrador(administradorEntity);
		return administradorEntity;
	}
}
