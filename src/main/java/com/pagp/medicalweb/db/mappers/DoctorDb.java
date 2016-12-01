package com.pagp.medicalweb.db.mappers;

import java.util.List;

import com.pagp.medicalweb.db.entity.DoctorEntity;

public interface DoctorDb {

	List<DoctorEntity> getDoctoresByEntidad(int idEntidad);

	DoctorEntity getDoctor(int idDoctor);

}
