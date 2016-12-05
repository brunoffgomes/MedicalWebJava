package com.pagp.medicalweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.DoctoresDao;
import com.pagp.medicalweb.dao.SolicitudesDao;
import com.pagp.medicalweb.db.entity.receta.DiagnosticoEntity;
import com.pagp.medicalweb.db.entity.receta.MedicamentoRecetaEntity;
import com.pagp.medicalweb.db.entity.receta.RecetaEntity;
import com.pagp.medicalweb.db.entity.receta.SolicitudEntity;
import com.pagp.medicalweb.web.dto.solicitud.DiagnosticoFormDto;
import com.pagp.medicalweb.web.dto.solicitud.MedicamentoRecetaFormDto;
import com.pagp.medicalweb.web.dto.solicitud.RecetaFormDto;
import com.pagp.medicalweb.web.dto.solicitud.SolicitudFormDto;
import com.pagp.medicalweb.web.enums.EstatusSolicitudEnum;

@Service
@Transactional
public class SolicitudesServices {

	@Autowired
	private SolicitudesDao solicitudesDao;

	@Autowired
	private DoctoresDao doctoresDao;

	public List<RecetaEntity> obtenerRecetas(int idEntidad) {
		return solicitudesDao.obtenerRecetas(idEntidad);
	}

	public RecetaEntity obtenerReceta(int idReceta) {
		return solicitudesDao.obtenerReceta(idReceta);
	}

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
		diagnosticoEntity.setEstatus(diagnosticoFormDto.getEstatus().toString());

		solicitudesDao.crearDiagnostico(diagnosticoEntity);

		SolicitudEntity solicitudEntity = doctoresDao.obtenerConsulta(diagnosticoEntity.getIdDiagnostico());
		solicitudEntity.setEstatus(EstatusSolicitudEnum.CERRADA.toString());
		solicitudesDao.actualizarSolicitud(solicitudEntity);

		return diagnosticoFormDto;
	}

	public RecetaFormDto crearReceta(RecetaFormDto recetaFormDto) {
		RecetaEntity recetaEntity = new RecetaEntity();
		recetaEntity.setComentarios(recetaFormDto.getComentarios());
		recetaEntity.setIdReceta(recetaFormDto.getIdReceta());
		solicitudesDao.crearReceta(recetaEntity);

		List<MedicamentoRecetaFormDto> list = recetaFormDto.getMedicamentos();

		for (MedicamentoRecetaFormDto medicamento : list) {

			MedicamentoRecetaEntity medicamentoRecetaEntity = new MedicamentoRecetaEntity();
			medicamentoRecetaEntity.setIdReceta(recetaEntity.getIdReceta());
			medicamentoRecetaEntity.setDesde(medicamento.getDesde());
			medicamentoRecetaEntity.setHasta(medicamento.getHasta());
			medicamentoRecetaEntity.setDosis(medicamento.getDosis());
			medicamentoRecetaEntity.setIdMedicamento(medicamento.getIdMedicamento());
			medicamentoRecetaEntity.setTipo_administracion(medicamento.getTipo_administracion().toString());
			medicamentoRecetaEntity.setToma(medicamento.getToma());

			solicitudesDao.crearMedicamentoReceta(medicamentoRecetaEntity);
		}

		DiagnosticoEntity diagnosticoEntity = doctoresDao.obtenerDiagnostico(recetaEntity.getIdReceta());
		diagnosticoEntity.setEstatus(EstatusSolicitudEnum.CERRADA.toString());
		solicitudesDao.actualizarDiagnostico(diagnosticoEntity);

		return recetaFormDto;
	}

}
