package com.pagp.medicalweb.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.PacientesDao;
import com.pagp.medicalweb.db.entity.receta.PacienteEntity;
import com.pagp.medicalweb.db.entity.receta.SolicitudEntity;
import com.pagp.medicalweb.web.dto.solicitud.SolicitudFormDto;
import com.pagp.medicalweb.web.enums.EstatusSolicitudEnum;
import com.pagp.medicalweb.web.enums.TipoSolicitudEnum;

@Service
@Transactional
public class PacientesServices {

	@Autowired
	private PacientesDao pacientesDao;

	public List<PacienteEntity> obtenerPacientes(int idEntidad) {
		return pacientesDao.obtenerPacientes(idEntidad);
	}

	public PacienteEntity obtenerPaciente(int idPaciente) {
		return pacientesDao.obtenerPaciente(idPaciente);
	}

	public List<SolicitudFormDto> getSolicitudes(int idPaciente) {
		List<SolicitudEntity> solicitudesEntity = pacientesDao.getSolicitudes(idPaciente);
		List<SolicitudFormDto> solicitudesFormDto = new ArrayList<>();
		for (SolicitudEntity solicitudEntity : solicitudesEntity) {
			SolicitudFormDto solicitudFormDto = new SolicitudFormDto();
			solicitudFormDto.setDescripion(solicitudEntity.getDescripcion());
			solicitudFormDto.setEstatus(EstatusSolicitudEnum.valueOf(solicitudEntity.getEstatus()));
			solicitudFormDto.setTipo_solicitud(TipoSolicitudEnum.valueOf(solicitudEntity.getTipo_solicitud()));
			solicitudFormDto.setIdSolicitud(solicitudEntity.getIdSolicitud());
			solicitudFormDto.setImpresion(solicitudEntity.getImpresion());
			solicitudFormDto.setIdPaciente(solicitudEntity.getIdPaciente());
			solicitudesFormDto.add(solicitudFormDto);
		}
		return solicitudesFormDto;
	}
}
