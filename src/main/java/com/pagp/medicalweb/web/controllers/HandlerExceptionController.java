package com.pagp.medicalweb.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pagp.medicalweb.web.dto.ErrorFormDto;

@ControllerAdvice
public class HandlerExceptionController {

	private Logger logger = LoggerFactory.getLogger(HandlerExceptionController.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorFormDto> exceptionHandler(Exception ex) {
		ErrorFormDto error = new ErrorFormDto("Hubo un error interno, contacta al administrador del sistema.");
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		logger.error("Error -->", ex);
		return new ResponseEntity<ErrorFormDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorFormDto> exceptionAccessDeniedException(AccessDeniedException ex) {
		ErrorFormDto error = new ErrorFormDto("Acceso denegado");
		error.setErrorCode(HttpStatus.FORBIDDEN.value());
		return new ResponseEntity<ErrorFormDto>(error, HttpStatus.FORBIDDEN);
	}
}