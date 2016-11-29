package com.pagp.medicalweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.RegistroDao;
import com.pagp.medicalweb.dao.UsuariosDao;
import com.pagp.medicalweb.db.entity.AdministradorEntity;
import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;
import com.pagp.medicalweb.db.entity.UsuarioEntity;
import com.pagp.medicalweb.web.dto.core.TipoUsuarioEnum;
import com.pagp.medicalweb.web.dto.registro.AdministradorFormDto;
import com.pagp.medicalweb.web.dto.registro.EntidadMedicaFormDto;

@Service
@Transactional
public class RegistroServices {

	@Autowired
	private UsuariosDao usuariosDao;

	@Autowired
	private RegistroDao registroDao;

	public Boolean validEmail(String email) {
		return usuariosDao.getUsuarioByEmail(email) == null;
	}

	public AdministradorFormDto crearAdministrador(AdministradorFormDto administradorFormDto) {

		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setApPaterno(administradorFormDto.getApPaterno());
		usuarioEntity.setApMaterno(administradorFormDto.getApMaterno());
		usuarioEntity.setNombre(administradorFormDto.getNombre());
		usuarioEntity.setEmail(administradorFormDto.getEmail());
		usuarioEntity.setFechaNacimiento(administradorFormDto.getFechaNacimiento());
		usuarioEntity.setPassword(administradorFormDto.getPassword());
		usuarioEntity.setTipo(TipoUsuarioEnum.ADMINISTRADOR.toString());

		usuariosDao.crearUsuario(usuarioEntity);

		AdministradorEntity administradorEntity = new AdministradorEntity();
		administradorEntity.setCargo(administradorFormDto.getCargo());
		administradorEntity.setId_administrador(usuarioEntity.getId_usuario());

		registroDao.guardarAdministrador(administradorEntity);

		return administradorFormDto;
	}

	public EntidadMedicaFormDto crearClinica(EntidadMedicaFormDto entidadMedicaFormDto) {
		
		EntidadEntity entidadEntity = new EntidadEntity();
		entidadEntity.setCalle(entidadMedicaFormDto.getCalle());
		entidadEntity.setCp(entidadMedicaFormDto.getCodigoPostal());
		entidadEntity.setNombre(entidadMedicaFormDto.getNombre());
		entidadEntity.setNumero(entidadMedicaFormDto.getNumero());
		entidadEntity.setRfc(entidadMedicaFormDto.getRfc());
		entidadEntity.setTelefono(entidadMedicaFormDto.getTelefono());
		entidadEntity.setTipo(entidadMedicaFormDto.getTipo().toString());
		entidadEntity.setIdAdministrador(entidadMedicaFormDto.getAdministrador().getIdUser());


		registroDao.guardarEntidad(entidadEntity);
			
		List<ModuloContratadoEntity> modulos = entidadMedicaFormDto.getModulos();
		
		for(ModuloContratadoEntity modulo :  modulos){
			modulo.setIdEntidad(entidadEntity.getIdEntidad());
			registroDao.guardarModuloContratado(modulo);
		}
		
		return entidadMedicaFormDto;
	}
}
