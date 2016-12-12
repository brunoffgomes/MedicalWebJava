package com.pagp.medicalweb.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.EntidadesDao;
import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.administrador.DetalleModuloEntity;
import com.pagp.medicalweb.web.dto.administrador.DetalleModuloFormDto;

@Service
@Transactional
public class EntidadesServices {

	@Autowired
	private EntidadesDao entidadesDao;

	public List<EntidadEntity> obtenerEntidades(int idAdministrador) {
		return entidadesDao.obtenerEntidades(idAdministrador);
	}

	public List<DetalleModuloFormDto> obtenerModulosEntidadActuales(int idEntidad) {
		List<DetalleModuloFormDto> resultado = new ArrayList<>();
		List<DetalleModuloEntity> modulos = entidadesDao.obtenerModulosEntidadActuales(idEntidad);
		for (DetalleModuloEntity moduloResultado : modulos) {
			DetalleModuloFormDto modulo = new DetalleModuloFormDto();
			modulo.setActivo(moduloResultado.getActivo());
			modulo.setFechaFin(moduloResultado.getFechaFin());
			modulo.setFechaInicio(moduloResultado.getFechaInicio());
			modulo.setNombre(moduloResultado.getNombre());
			modulo.setPrecio(moduloResultado.getPrecio());
			resultado.add(modulo);
		}
		return resultado;
	}

	public List<EntidadEntity> obtenerEntidades() {
		return entidadesDao.obtenerEntidades();
	}
}
