package com.pagp.medicalweb.services.auditoria;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.AuditoriaDao;
import com.pagp.medicalweb.db.entity.auditoria.RegistroEntity;
import com.pagp.medicalweb.web.core.dto.AuthenticatedUser;

@Aspect
public class AuditoriaAspect {

	@Autowired
	private AuditoriaDao auditoriaDao;

	private Logger logger = LoggerFactory.getLogger(AuditoriaAspect.class);

	@After("@annotation(auditable)")
	@Transactional
	public void logAuditActivity(JoinPoint jp, Auditable auditable) {
		String actionType = auditable.actionType().getDescription();
		AuthenticatedUser auth = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		Integer idPaciente = null;
		Object[] signatureArgs = jp.getArgs();
		for (Object signatureArg : signatureArgs) {
			idPaciente = extractTargetAuditingUser(signatureArg);
			if (idPaciente != null)
				break;
		}

		RegistroEntity registroEntity = new RegistroEntity();
		registroEntity.setIdUsuario(auth.getId());
		registroEntity.setTipo_evento(actionType);
		registroEntity.setFecha(new Date());
		registroEntity.setIdPaciente(idPaciente);

		auditoriaDao.crearRegistro(registroEntity);
		logger.info(actionType);
	}

	private Integer extractTargetAuditingUser(Object obj) {
		Class<?> cl = obj.getClass();
		Integer result = null;
		try {
			for (Field f : cl.getDeclaredFields())
				for (Annotation a : f.getAnnotations()) {
					if (a.annotationType() == AuditingTargetPaciente.class) {
						f.setAccessible(true);
						Field annotatedFieldName = cl.getDeclaredField(f.getName());
						annotatedFieldName.setAccessible(true);
						int annotatedFieldVal = (int) annotatedFieldName.get(obj);
						result = annotatedFieldVal;
					}
				}
		} catch (Exception e) {
			logger.error("Error extracting auditing annotations from obj" + obj.getClass());
		}
		return result;
	}
}
