package com.pagp.medicalweb.web.core;

import java.beans.PropertyEditorSupport;
import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pagp.medicalweb.web.dto.laboratorio.ResultadoFormDto;

public class ResultadoFormDtoDataBinder extends PropertyEditorSupport {

	private Object value;

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			value = mapper.readValue(text, ResultadoFormDto.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
