package com.pagp.medicalweb.services.auditoria;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.pagp.medicalweb.services.enums.AuditingActionTypeEnum;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface Auditable {
	AuditingActionTypeEnum actionType();
}
