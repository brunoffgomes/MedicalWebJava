package com.pagp.medicalweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.SolicitudesDao;
import com.pagp.medicalweb.db.entity.receta.DiagnosticoEntity;
import com.pagp.medicalweb.db.entity.receta.RecetaEntity;
import com.pagp.medicalweb.db.entity.receta.SolicitudEntity;
import com.pagp.medicalweb.web.dto.solicitud.DiagnosticoFormDto;
import com.pagp.medicalweb.web.dto.solicitud.RecetaFormDto;
import com.pagp.medicalweb.web.dto.solicitud.SolicitudFormDto;

@Service
@Transactional
public class SolicitudesServices {

	@Autowired
	private SolicitudesDao solicitudesDao;

	public SolicitudFormDto crearSolicitud(SolicitudFormDto solicitudFormDto) {
		SolicitudEntity solicitudEntity = new SolicitudEntity();
		solicitudEntity.setDescripcion(solicitudFormDto.getDescripcion());
		solicitudEntity.setIdPaciente(solicitudFormDto.getIdPaciente());
		solicitudEntity.setEstatus(solicitudFormDto.getEstatus().toString());
		solicitudEntity.setImpresion(solicitudFormDto.getImpresion());
		solicitudEntity.setTipo_solicitud(solicitudFormDto.getTipo_solicitud().toString());

		solicitudesDao.crearSolicitud(solicitudEntity);

		solicitudFormDto.setIdSolicitud(solicitudEntity.getIdSolicitud());
		return solicitudFormDto;
	}

	public DiagnosticoFormDto crearDiagnostico(DiagnosticoFormDto diagnosticoFormDto) {
		DiagnosticoEntity diagnosticoEntity = new DiagnosticoEntity();
		diagnosticoEntity.setDiagnostico(diagnosticoFormDto.getDiagnostico());
		diagnosticoEntity.setIdDiagnostico(diagnosticoFormDto.getIdDiagnostico());
		diagnosticoEntity.setIdDoctor(diagnosticoFormDto.getIdDoctor());
		diagnosticoEntity.setTratamiento(diagnosticoFormDto.getTratamiento());

		solicitudesDao.crearDiagnostico(diagnosticoEntity);
		return diagnosticoFormDto;
	}

	public RecetaFormDto crearReceta(RecetaFormDto recetaFormDto) {
		RecetaEntity recetaEntity = new RecetaEntity();

		solicitudesDao.crearReceta(recetaEntity);
		return recetaFormDto;
	}

}
