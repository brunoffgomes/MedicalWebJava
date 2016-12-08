package com.pagp.medicalweb.db.mappers;

import com.pagp.medicalweb.db.entity.AdministradorCEEntity;
import com.pagp.medicalweb.db.entity.AdministradorEntity;
import com.pagp.medicalweb.db.entity.DoctorEntity;
import com.pagp.medicalweb.db.entity.EnfermeroEntity;
import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.FarmacologoEntity;
import com.pagp.medicalweb.db.entity.LaboratoristaEntity;
import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;
import com.pagp.medicalweb.db.entity.receta.PacienteEntity;

public interface RegistroDb {

	void insertEntidad(EntidadEntity entidadEntity);

	void insertarModuloContratado(ModuloContratadoEntity moduloContratadoEntity);

	void insertAdministrador(AdministradorEntity administradorEntity);

	void insertAdministradorCE(AdministradorCEEntity administradorCEEntity);

	void insertEnfermero(EnfermeroEntity enfermeroEntity);

	void insertPaciente(PacienteEntity pacienteEntity);

	void insertDoctor(DoctorEntity doctorEntity);

	void insertFarmacologo(FarmacologoEntity farmacologoEntity);

	void insertLaboratorista(LaboratoristaEntity laboratoristaEntity);

}
