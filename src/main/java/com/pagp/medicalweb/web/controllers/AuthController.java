package com.pagp.medicalweb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pagp.medicalweb.services.api.AuthServices;
import com.pagp.medicalweb.services.models.UserLoginServicesInDto;
import com.pagp.medicalweb.services.models.UserLoginServicesOutDto;
import com.pagp.medicalweb.web.dto.UserLogginFormInDto;
import com.pagp.medicalweb.web.dto.UserLogginFormOutDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthServices authServices;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserLogginFormOutDto loggin(@RequestBody UserLogginFormInDto user) {

		UserLoginServicesInDto userLoginServicesInDto = new UserLoginServicesInDto();
		userLoginServicesInDto.setPassword(user.getPassword());
		userLoginServicesInDto.setUsername(user.getUsername());

		UserLoginServicesOutDto userLoginServicesOutDto = authServices.login(userLoginServicesInDto);

		UserLogginFormOutDto userLogginFormOutDto = new UserLogginFormOutDto();
		userLogginFormOutDto.setToken(userLoginServicesOutDto.getToken());
		userLogginFormOutDto.setEstatus(userLoginServicesOutDto.getEstatus());

		return userLogginFormOutDto;
	}

}
