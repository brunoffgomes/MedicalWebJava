package com.pagp.medicalweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagp.medicalweb.dao.DoctoresDao;
import com.pagp.medicalweb.dao.EntidadesDao;
import com.pagp.medicalweb.dao.UsuariosDao;
import com.pagp.medicalweb.db.entity.AdministradorCEEntity;
import com.pagp.medicalweb.db.entity.DoctorEntity;
import com.pagp.medicalweb.db.entity.EnfermeroEntity;
import com.pagp.medicalweb.db.entity.FarmacologoEntity;
import com.pagp.medicalweb.db.entity.LaboratoristaEntity;
import com.pagp.medicalweb.db.entity.UsuarioEntity;
import com.pagp.medicalweb.db.entity.administrador.DetalleModuloEntity;
import com.pagp.medicalweb.services.models.UserLoginServicesInDto;
import com.pagp.medicalweb.services.models.UserLoginServicesOutDto;
import com.pagp.medicalweb.web.core.JwtUtil;
import com.pagp.medicalweb.web.core.dto.JwtUserDto;
import com.pagp.medicalweb.web.dto.core.TipoUsuarioEnum;
import com.pagp.medicalweb.web.enums.UserLoginEstatusEnum;

/*
 * AuthServices
 *  Servicio para autenticar un usuario,
 *  Genera el token de usuario con sus propiedades
 *  En caso de error se regresa el error de autenticacion
 * */
@Service
public class AuthServices {

	@Autowired
	private UsuariosDao usuariosDao;

	@Autowired
	private DoctoresDao doctoresDao;

	@Autowired
	private EntidadesDao entidadesDao;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private ValidadorAccesosComponent validadorAccesos;

	private String rolePrefix = "ROLE_";

	/*
	 * Valida la credenciales del usuario y generar el token de acceso en caso
	 * de error regresa la causa del error de acceso
	 */
	public UserLoginServicesOutDto login(UserLoginServicesInDto user) {
		// Obtener un usuario por su email
		UsuarioEntity usuarioEntity = usuariosDao.getUsuarioByEmail(user.getUsername());
		UserLoginServicesOutDto userLoginServicesOutDto = new UserLoginServicesOutDto();
		if (usuarioEntity == null) {
			// Dar respuesta para cuando el usuario no existe
			userLoginServicesOutDto.setEstatus(UserLoginEstatusEnum.INEXISTENTE);
		} else {

			if (usuarioEntity.getPassword().equals(user.getPassword())) {

				// Crear datos para token de acceso al sistema
				JwtUserDto jwtUserDto = new JwtUserDto();
				jwtUserDto.setId(usuarioEntity.getId_usuario());
				jwtUserDto.setUsername(usuarioEntity.getEmail());
				jwtUserDto.setRole(rolePrefix.concat(usuarioEntity.getTipo()));

				// Obtener el tipo de usuario
				TipoUsuarioEnum tipoUsuarioEnum = TipoUsuarioEnum.valueOf(usuarioEntity.getTipo());
				int idUsuario = usuarioEntity.getId_usuario();

				// Si el tipo de usuario no es administrador
				if (!TipoUsuarioEnum.ADMINISTRADOR.equals(tipoUsuarioEnum)
						&& !TipoUsuarioEnum.SUPERADMINISTRADOR.equals(tipoUsuarioEnum)) {

					int idEntidad = obtenerIdEntidad(idUsuario, tipoUsuarioEnum);
					jwtUserDto.setIdEntidad(idEntidad);

					// Se obtiene los detalles de modulos para el usuario que
					// tiene activos para el usuario
					List<DetalleModuloEntity> modulos = entidadesDao
							.obtenerModulosEntidadActivos(jwtUserDto.getIdEntidad());

					// Valida si puede entrar el usuario
					if (!validadorAccesos.puedeEntrarUsuario(modulos, tipoUsuarioEnum)) {
						userLoginServicesOutDto.setEstatus(UserLoginEstatusEnum.MODULO_NO_ACTIVO);
						return userLoginServicesOutDto;
					}

					String[] modulosActivos = new String[modulos.size()];
					for (int i = 0; i < modulos.size(); i++)
						modulosActivos[i] = modulos.get(i).getNombre();
					jwtUserDto.setModulosActivos(modulosActivos);

				}
				// Generar el token de acceso para acceso
				String token = jwtUtil.generateToken(jwtUserDto);
				userLoginServicesOutDto.setToken(token);
				// Dar respuesta de usuario activo
				userLoginServicesOutDto.setEstatus(UserLoginEstatusEnum.ACTIVO);
			} else {
				// Dar respuesta de credenciales incorrectas
				userLoginServicesOutDto.setEstatus(UserLoginEstatusEnum.BAD_CREDENTIAL);
			}

		}
		return userLoginServicesOutDto;
	}

	public int obtenerIdEntidad(int idUsuario, TipoUsuarioEnum tipoUsuarioEnum) {
		int idEntidad = 0;
		switch (tipoUsuarioEnum) {
		// Por tipo de usuario se obtiene sus caracteristicas
		// propias
		case DOCTOR:
			DoctorEntity doctorEntity = doctoresDao.getDoctor(idUsuario);
			idEntidad = doctorEntity.getIdEntidad();
			break;
		case ENFERMERO:
			EnfermeroEntity enfermeroEntity = entidadesDao.getEnfermero(idUsuario);
			idEntidad = enfermeroEntity.getIdEntidad();
			break;
		case FARMACIA:
			FarmacologoEntity farmacologoEntity = entidadesDao.getFarmacologo(idUsuario);
			idEntidad = farmacologoEntity.getIdEntidad();
			break;
		case ADMINISTRADOR_CE:
			AdministradorCEEntity administradorCEEntity = entidadesDao.getAdministradorCE(idUsuario);
			idEntidad = administradorCEEntity.getIdEntidad();
			break;

		case LABORATORIO:
			LaboratoristaEntity laboratoristaEntity = entidadesDao.getLaboratorista(idUsuario);
			idEntidad = laboratoristaEntity.getIdEntidad();
			break;
		default:
			break;

		}
		return idEntidad;
	}
}
