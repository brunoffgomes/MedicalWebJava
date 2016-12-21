package com.pagp.medicalweb.services.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.pagp.medicalweb.dao.DoctoresDao;
import com.pagp.medicalweb.dao.LaboratorioDao;
import com.pagp.medicalweb.dao.SolicitudesDao;
import com.pagp.medicalweb.db.entity.laboratorio.AnalisisEntity;
import com.pagp.medicalweb.db.entity.laboratorio.EvidenciaEntity;
import com.pagp.medicalweb.db.entity.laboratorio.MuestraEntity;
import com.pagp.medicalweb.db.entity.laboratorio.ResultadoEntity;
import com.pagp.medicalweb.db.entity.receta.ConsultaEntity;
import com.pagp.medicalweb.db.entity.receta.SolicitudEntity;
import com.pagp.medicalweb.services.auditoria.Auditable;
import com.pagp.medicalweb.services.enums.AuditingActionTypeEnum;
import com.pagp.medicalweb.web.dto.laboratorio.AnalisisFormDto;
import com.pagp.medicalweb.web.dto.laboratorio.EvidenciaFormDto;
import com.pagp.medicalweb.web.dto.laboratorio.MuestraFormDto;
import com.pagp.medicalweb.web.dto.laboratorio.ResultadoFormDto;
import com.pagp.medicalweb.web.enums.EstatusSolicitudEnum;

@Service
@Transactional
public class LaboratorioServices {

	public static final String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=misrecursosprueba5504;AccountKey=Ev6H570opCvvVvbanrFsX6aMFNZ3DHioKV/u4XprYmKGg4LBlpinfWmYqOBwKse5UEc3Z+53Ip/Xf1JCuqzfDQ==";
	public static final String CONTAINER = "analisis";
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

	public List<ConsultaEntity> registrosResultados(int idEntidad) {
		// Se obtienen solicitudes tipo dar resultados
		return laboratorioDao.registrosResultados(idEntidad);
	}

	@Auditable(actionType = AuditingActionTypeEnum.CREAR_ANALISIS)
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

	@Auditable(actionType = AuditingActionTypeEnum.CREAR_RESULTADO)
	public void crearResultado(MultipartFile[] files, ResultadoFormDto resultadoFormDto) {
		ResultadoEntity resultadoEntity = new ResultadoEntity();
		resultadoEntity.setFecha(new Date());
		resultadoEntity.setIdResultado(resultadoFormDto.getIdResultado());
		resultadoEntity.setDescripcion(resultadoFormDto.getObservaciones());

		laboratorioDao.crearResultado(resultadoEntity);

		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			EvidenciaFormDto evidenciaFormDto = resultadoFormDto.getEvidencias().get(i);
			String fileUUID = guardaArchivoAzure(file);
			EvidenciaEntity evidenciaEntity = new EvidenciaEntity();
			evidenciaEntity.setFile(fileUUID);
			evidenciaEntity.setNombre(evidenciaFormDto.getNombre());
			evidenciaEntity.setIdAnalisis(resultadoEntity.getIdResultado());
			evidenciaEntity.setFecha(new Date());
			String[] split = file.getOriginalFilename().split(Pattern.quote("."));
			evidenciaEntity.setExt(split[split.length - 1]);

			laboratorioDao.crearEvidencia(evidenciaEntity);
		}

		AnalisisEntity analisisEntity = laboratorioDao.obtenerAnalisisPorId(resultadoEntity.getIdResultado());
		analisisEntity.setEstatus(EstatusSolicitudEnum.CERRADA.toString());

		laboratorioDao.actualizarAnalisis(analisisEntity);

	}

	public String guardaArchivoAzure(MultipartFile file) {
		try {
			CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
			CloudBlobClient serviceClient = account.createCloudBlobClient();
			CloudBlobContainer container = serviceClient.getContainerReference("analisis");
			container.createIfNotExists();
			String uniqueID = UUID.randomUUID().toString();
			CloudBlockBlob blob = container.getBlockBlobReference(uniqueID);
			blob.uploadFromByteArray(file.getBytes(), 0, (int) file.getSize());
			return uniqueID;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
