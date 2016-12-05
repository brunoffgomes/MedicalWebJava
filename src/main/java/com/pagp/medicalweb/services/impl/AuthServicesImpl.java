package com.pagp.medicalweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagp.medicalweb.dao.DoctoresDao;
import com.pagp.medicalweb.dao.EntidadesDao;
import com.pagp.medicalweb.dao.UsuariosDao;
import com.pagp.medicalweb.db.entity.DoctorEntity;
import com.pagp.medicalweb.db.entity.EnfermeroEntity;
import com.pagp.medicalweb.db.entity.FarmacologoEntity;
import com.pagp.medicalweb.db.entity.UsuarioEntity;
import com.pagp.medicalweb.services.api.AuthServices;
import com.pagp.medicalweb.services.models.UserLoginServicesInDto;
import com.pagp.medicalweb.services.models.UserLoginServicesOutDto;
import com.pagp.medicalweb.web.core.JwtUtil;
import com.pagp.medicalweb.web.core.dto.JwtUserDto;
import com.pagp.medicalweb.web.dto.core.TipoUsuarioEnum;
import com.pagp.medicalweb.web.enums.UserLoginEstatusEnum;

@Service
public class AuthServicesImpl implements AuthServices {

	@Autowired
	private UsuariosDao usuariosDao;

	@Autowired
	private DoctoresDao doctoresDao;
	
	@Autowired
	private EntidadesDao entidadesDao;

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
				jwtUserDto.setId(usuarioEntity.getId_usuario());
				jwtUserDto.setUsername(usuarioEntity.getEmail());
				jwtUserDto.setRole(usuarioEntity.getTipo());

				TipoUsuarioEnum tipoUsuarioEnum = TipoUsuarioEnum.valueOf(usuarioEntity.getTipo());
				int idUsuario = usuarioEntity.getId_usuario();
				
				
				if (!TipoUsuarioEnum.ADMINISTRADOR.equals(tipoUsuarioEnum)) {
					switch (tipoUsuarioEnum) {
					case DOCTOR:
						DoctorEntity doctorEntity = doctoresDao.getDoctor(idUsuario);
						jwtUserDto.setIdEntidad(doctorEntity.getIdEntidad());
						break;
					case ENFERMERO:
						EnfermeroEntity enfermeroEntity =  entidadesDao.getEnfermero(idUsuario);
						jwtUserDto.setIdEntidad(enfermeroEntity.getIdEntidad());
						break;
					case FARMACIA:
						FarmacologoEntity farmacologoEntity =  entidadesDao.getFarmacologo(idUsuario);
						jwtUserDto.setIdEntidad(farmacologoEntity.getIdEntidad());
						break;
					default:
						break;
					}

				}
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
