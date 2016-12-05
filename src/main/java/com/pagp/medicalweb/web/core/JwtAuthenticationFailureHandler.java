package com.pagp.medicalweb.web.core;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pagp.medicalweb.web.core.exceptions.JwtTokenMissingException;
import com.pagp.medicalweb.web.dto.ErrorFormDto;


@Component("jwtAuthenticationFailureHandler")
public class JwtAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		if (exception.getClass().isAssignableFrom(JwtTokenMissingException.class)) {
			showMessage(exception.getMessage(), response);
		} else {
			showMessage("USER_DISABLED", response);
		}

	}

	private void showMessage(String mensaje, HttpServletResponse response) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		StringWriter json = new StringWriter();

		ErrorFormDto errorFormDto = new ErrorFormDto(mensaje);
		errorFormDto.setErrorCode(HttpServletResponse.SC_UNAUTHORIZED);
		objectMapper.writeValue(json, errorFormDto);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		response.getWriter().print(json.toString());
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().flush();
	}
}