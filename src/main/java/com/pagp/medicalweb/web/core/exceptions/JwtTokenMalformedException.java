package com.pagp.medicalweb.web.core.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMalformedException extends AuthenticationException {

	/**
	 *
	 */
	private static final long serialVersionUID = -2228804324163605845L;

	public JwtTokenMalformedException(String msg) {
		super(msg);
	}
}