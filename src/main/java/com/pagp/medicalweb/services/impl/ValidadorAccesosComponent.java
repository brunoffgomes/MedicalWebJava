package com.pagp.medicalweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pagp.medicalweb.dao.EntidadesDao;
import com.pagp.medicalweb.db.entity.administrador.DetalleModuloEntity;
import com.pagp.medicalweb.web.dto.core.TipoModuloEnum;
import com.pagp.medicalweb.web.dto.core.TipoUsuarioEnum;

@Component
public class ValidadorAccesosComponent {

	@Autowired
	private EntidadesDao entidadesDao;

	public Boolean puedeEntrarUsuario(int idEntidad, TipoUsuarioEnum tipoUsuarioEnum) {
		List<DetalleModuloEntity> modulos = entidadesDao.obtenerModulosEntidadActivos(idEntidad);
		return puedeEntrarUsuario(modulos, tipoUsuarioEnum);
	}

	public Boolean puedeEntrarUsuario(List<DetalleModuloEntity> modulosDetalle, TipoUsuarioEnum tipoUsuarioEnum) {
		if (tipoUsuarioEnum.equals(TipoUsuarioEnum.ADMINISTRADOR_CE))
			if (!modulosDetalle.isEmpty())
				return true;

		for (DetalleModuloEntity moduloDetalle : modulosDetalle) {
			TipoModuloEnum tipoModulo = TipoModuloEnum.valueOf(moduloDetalle.getNombre());
			switch (tipoModulo) {
			case CONSULTA:
				if (tipoUsuarioEnum.equals(TipoUsuarioEnum.DOCTOR) || tipoUsuarioEnum.equals(TipoUsuarioEnum.ENFERMERO))
					return true;
			case LABORATORIO:
				if (tipoUsuarioEnum.equals(TipoUsuarioEnum.LABORATORIO))
					return true;
			case FARMACIA:
				if (tipoUsuarioEnum.equals(TipoUsuarioEnum.FARMACIA))
					return true;
			}
		}
		return false;
	}
}
