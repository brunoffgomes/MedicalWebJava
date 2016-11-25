package com.pagp.medicalweb.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pagp.medicalweb.web.dto.ErrorFormDto;

@ControllerAdvice
public class HandlerExceptionController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorFormDto> exceptionHandler(Exception ex) {
		ErrorFormDto error = new ErrorFormDto("Please contact your administrator");
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ErrorFormDto>(error, HttpStatus.OK);
	}
}