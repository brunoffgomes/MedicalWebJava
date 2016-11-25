package com.pagp.medicalweb.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.web.dto.UserLogginFormInDto;
import com.pagp.medicalweb.web.dto.UserLogginFormOutDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserLogginFormOutDto loggin(UserLogginFormInDto user) {
		UserLogginFormOutDto result = new UserLogginFormOutDto();
		return result;
	}

}
