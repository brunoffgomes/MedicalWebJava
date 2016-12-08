package com.pagp.medicalweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pagp.medicalweb.db.entity.AdministradorCEEntity;
import com.pagp.medicalweb.db.entity.AdministradorEntity;
import com.pagp.medicalweb.db.entity.DoctorEntity;
import com.pagp.medicalweb.db.entity.EnfermeroEntity;
import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.FarmacologoEntity;
import com.pagp.medicalweb.db.entity.LaboratoristaEntity;
import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;
import com.pagp.medicalweb.db.entity.receta.PacienteEntity;
import com.pagp.medicalweb.db.mappers.RegistroDb;

@Repository
public class RegistroDao {

	@Autowired
	private RegistroDb registroDb;

	public AdministradorEntity guardarAdministrador(AdministradorEntity administradorEntity) {
		registroDb.insertAdministrador(administradorEntity);
		return administradorEntity;
	}

	public AdministradorCEEntity guardarAdministradorCE(AdministradorCEEntity administradorCEEntity) {
		registroDb.insertAdministradorCE(administradorCEEntity);
		return administradorCEEntity;
	}

	public EntidadEntity guardarEntidad(EntidadEntity entidadEntity) {
		registroDb.insertEntidad(entidadEntity);
		return entidadEntity;
	}

	public ModuloContratadoEntity guardarModuloContratado(ModuloContratadoEntity moduloContratadoEntity) {
		registroDb.insertarModuloContratado(moduloContratadoEntity);
		return moduloContratadoEntity;
	}

	public EnfermeroEntity guardarEnfermero(EnfermeroEntity enfermeroEntity) {
		registroDb.insertEnfermero(enfermeroEntity);
		return enfermeroEntity;
	}

	public FarmacologoEntity guardarFarmacologo(FarmacologoEntity farmacologoEntity) {
		registroDb.insertFarmacologo(farmacologoEntity);
		return farmacologoEntity;
	}

	public LaboratoristaEntity guardarLaboratorista(LaboratoristaEntity laboratoristaEntity) {
		registroDb.insertLaboratorista(laboratoristaEntity);
		return laboratoristaEntity;
	}

	public DoctorEntity guardarDoctor(DoctorEntity doctorEntity) {
		registroDb.insertDoctor(doctorEntity);
		return doctorEntity;
	}

	public PacienteEntity guardarPaciente(PacienteEntity pacienteEntity) {
		registroDb.insertPaciente(pacienteEntity);
		return pacienteEntity;
	}
}
