package com.pagp.medicalweb.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.DoctoresDao;
import com.pagp.medicalweb.dao.LaboratorioDao;
import com.pagp.medicalweb.dao.SolicitudesDao;
import com.pagp.medicalweb.db.entity.laboratorio.AnalisisEntity;
import com.pagp.medicalweb.db.entity.laboratorio.MuestraEntity;
import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;
import com.pagp.medicalweb.db.entity.receta.SolicitudEntity;
import com.pagp.medicalweb.web.dto.laboratorio.AnalisisFormDto;
import com.pagp.medicalweb.web.dto.laboratorio.MuestraFormDto;
import com.pagp.medicalweb.web.enums.EstatusSolicitudEnum;

@Service
@Transactional
public class LaboratorioServices {

	@Autowired
	private LaboratorioDao laboratorioDao;

	@Autowired
	private DoctoresDao doctoresDao;

	@Autowired
	private SolicitudesDao solicitudesDao;

	public List<ConsultaEntity> obtenerAnalisis(int idEntidad) {
		// Se obtienen solicitudes tipo analisis
		return laboratorioDao.obtenerConsultas(idEntidad);
	}

	public void crearAnalisis(AnalisisFormDto analisisFormDto) {
		AnalisisEntity analisisEntity = new AnalisisEntity();

		// mapeamos la informacion de objeto json a objecto dao
		analisisEntity.setEstatus(EstatusSolicitudEnum.ABIERTA.toString());
		analisisEntity.setFecha(new Date());
		analisisEntity.setIdAnalisis(analisisFormDto.getIdAnalisis());
		analisisEntity.setIdLaboratorista(analisisFormDto.getIdLaboratorista());
		analisisEntity.setObservaciones(analisisFormDto.getObservaciones());

		// Primero guardamos el analisis
		laboratorioDao.crearAnalisis(analisisEntity);

		// Luego guardamos cada muestra con referencia a nuestro analisis
		for (MuestraFormDto muestraFormDto : analisisFormDto.getMuestras()) {
			MuestraEntity muestraEntity = new MuestraEntity();
			// Se mepea cada muestra
			muestraEntity.setIdAnalisis(analisisEntity.getIdAnalisis());
			muestraEntity.setNumero(muestraFormDto.getNumero());
			muestraEntity.setTipo_muestra(muestraFormDto.getTipo_muestra());

			// Se guarda la muestra
			laboratorioDao.crearMuestra(muestraEntity);
		}

		// Actulizar estatus solicitud
		SolicitudEntity solicitudEntity = doctoresDao.obtenerConsulta(analisisEntity.getIdAnalisis());
		solicitudEntity.setEstatus(EstatusSolicitudEnum.CERRADA.toString());
		solicitudesDao.actualizarSolicitud(solicitudEntity);
	}

}
