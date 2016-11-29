package com.pagp.medicalweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagp.medicalweb.dao.UsuariosDao;
import com.pagp.medicalweb.db.entity.UsuarioEntity;
import com.pagp.medicalweb.services.api.AuthServices;
import com.pagp.medicalweb.services.models.UserLoginServicesInDto;
import com.pagp.medicalweb.services.models.UserLoginServicesOutDto;
import com.pagp.medicalweb.web.core.JwtUtil;
import com.pagp.medicalweb.web.core.dto.JwtUserDto;
import com.pagp.medicalweb.web.enums.UserLoginEstatusEnum;

@Service
public class AuthServicesImpl implements AuthServices {

	@Autowired
	private UsuariosDao usuariosDao;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public UserLoginServicesOutDto login(UserLoginServicesInDto user) {
		UsuarioEntity usuarioEntity = usuariosDao.getUsuarioByEmail(user.getUsername());
		UserLoginServicesOutDto userLoginServicesOutDto = new UserLoginServicesOutDto();
		if (usuarioEntity == null) {
			userLoginServicesOutDto.setEstatus(UserLoginEstatusEnum.INEXISTENTE);
		} else {

			if (usuarioEntity.getPassword().equals(user.getPassword())) {
				JwtUserDto jwtUserDto = new JwtUserDto();
				String token = jwtUtil.generateToken(jwtUserDto);
				userLoginServicesOutDto.setToken(token);
				userLoginServicesOutDto.setEstatus(UserLoginEstatusEnum.ACTIVO);
			} else {
				userLoginServicesOutDto.setEstatus(UserLoginEstatusEnum.BAD_CREDENTIAL);
			}

		}
		return userLoginServicesOutDto;
	}

}
