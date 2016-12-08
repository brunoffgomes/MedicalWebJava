package com.pagp.medicalweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagp.medicalweb.dao.RegistroDao;
import com.pagp.medicalweb.dao.UsuariosDao;
import com.pagp.medicalweb.db.entity.AdministradorCEEntity;
import com.pagp.medicalweb.db.entity.AdministradorEntity;
import com.pagp.medicalweb.db.entity.DoctorEntity;
import com.pagp.medicalweb.db.entity.EnfermeroEntity;
import com.pagp.medicalweb.db.entity.EntidadEntity;
import com.pagp.medicalweb.db.entity.FarmacologoEntity;
import com.pagp.medicalweb.db.entity.LaboratoristaEntity;
import com.pagp.medicalweb.db.entity.ModuloContratadoEntity;
import com.pagp.medicalweb.db.entity.UsuarioEntity;
import com.pagp.medicalweb.db.entity.receta.PacienteEntity;
import com.pagp.medicalweb.services.auditoria.Auditable;
import com.pagp.medicalweb.services.enums.AuditingActionTypeEnum;
import com.pagp.medicalweb.web.dto.core.TipoUsuarioEnum;
import com.pagp.medicalweb.web.dto.core.UsuarioBaseFormDto;
import com.pagp.medicalweb.web.dto.registro.AdministradorCEFormDto;
import com.pagp.medicalweb.web.dto.registro.AdministradorFormDto;
import com.pagp.medicalweb.web.dto.registro.DoctorFormDto;
import com.pagp.medicalweb.web.dto.registro.EnfermeroFormDto;
import com.pagp.medicalweb.web.dto.registro.EntidadMedicaFormDto;
import com.pagp.medicalweb.web.dto.registro.FarmacologoFormDto;
import com.pagp.medicalweb.web.dto.registro.LaboratoristaFormDto;

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

	public AdministradorCEFormDto crearAdministradorCE(AdministradorCEFormDto administradorCEFormDto) {

		UsuarioEntity usuarioEntity = crearUsuario(administradorCEFormDto, TipoUsuarioEnum.ADMINISTRADOR_CE);

		AdministradorCEEntity administradorEntity = new AdministradorCEEntity();
		administradorEntity.setIdEntidad(administradorCEFormDto.getIdEntidad());
		administradorEntity.setCargo(administradorCEFormDto.getCargo());
		administradorEntity.setIdAdministradorCE(usuarioEntity.getId_usuario());
		administradorEntity.setCedula_profesional(administradorCEFormDto.getCedula_profesional());

		registroDao.guardarAdministradorCE(administradorEntity);

		return administradorCEFormDto;
	}

	public AdministradorFormDto crearAdministrador(AdministradorFormDto administradorFormDto) {

		UsuarioEntity usuarioEntity = crearUsuario(administradorFormDto, TipoUsuarioEnum.ADMINISTRADOR);

		AdministradorEntity administradorEntity = new AdministradorEntity();
		administradorEntity.setCargo(administradorFormDto.getCargo());
		administradorEntity.setId_administrador(usuarioEntity.getId_usuario());

		registroDao.guardarAdministrador(administradorEntity);

		return administradorFormDto;
	}

	public UsuarioBaseFormDto crearSuperAdministrador(UsuarioBaseFormDto usuarioBaseFormDto) {

		crearUsuario(usuarioBaseFormDto, TipoUsuarioEnum.SUPERADMINISTRADOR);

		return usuarioBaseFormDto;
	}

	public EnfermeroFormDto crearEnfermero(EnfermeroFormDto enfermeroFormDto) {

		UsuarioEntity usuarioEntity = crearUsuario(enfermeroFormDto, TipoUsuarioEnum.ENFERMERO);

		EnfermeroEntity enfermeroEntity = new EnfermeroEntity();
		enfermeroEntity.setCedula_profesional(enfermeroFormDto.getCedula_profesional());
		enfermeroEntity.setIdEntidad(enfermeroFormDto.getIdEntidad());
		enfermeroEntity.setIdEnfermero(usuarioEntity.getId_usuario());

		registroDao.guardarEnfermero(enfermeroEntity);

		return enfermeroFormDto;
	}

	public FarmacologoFormDto crearFarmacologo(FarmacologoFormDto farmacologoFormDto) {

		UsuarioEntity usuarioEntity = crearUsuario(farmacologoFormDto, TipoUsuarioEnum.FARMACIA);

		FarmacologoEntity farmacologoEntity = new FarmacologoEntity();
		farmacologoEntity.setCedula_profesional(farmacologoFormDto.getCedula_profesional());
		farmacologoEntity.setIdEntidad(farmacologoFormDto.getIdEntidad());
		farmacologoEntity.setIdFarmacologo(usuarioEntity.getId_usuario());

		registroDao.guardarFarmacologo(farmacologoEntity);

		return farmacologoFormDto;
	}

	public LaboratoristaFormDto crearLaboratorista(LaboratoristaFormDto laboratoristaFormDto) {

		UsuarioEntity usuarioEntity = crearUsuario(laboratoristaFormDto, TipoUsuarioEnum.LABORATORIO);

		LaboratoristaEntity laboratoristaEntity = new LaboratoristaEntity();
		laboratoristaEntity.setCedula_profesional(laboratoristaFormDto.getCedula_profesional());
		laboratoristaEntity.setIdEntidad(laboratoristaFormDto.getIdEntidad());
		laboratoristaEntity.setIdLaboratorista(usuarioEntity.getId_usuario());

		registroDao.guardarLaboratorista(laboratoristaEntity);

		return laboratoristaFormDto;
	}

	public DoctorFormDto crearDoctor(DoctorFormDto doctorFormDto) {

		UsuarioEntity usuarioEntity = crearUsuario(doctorFormDto, TipoUsuarioEnum.DOCTOR);

		DoctorEntity doctorEntity = new DoctorEntity();
		doctorEntity.setIdDoctor(usuarioEntity.getId_usuario());
		doctorEntity.setCedula_profesional(doctorFormDto.getCedula_profesional());
		doctorEntity.setEspecialidad(doctorFormDto.getEspecialidad());
		doctorEntity.setSub_especialidad(doctorFormDto.getSub_especialidad());
		doctorEntity.setIdEntidad(doctorFormDto.getIdEntidad());
		registroDao.guardarDoctor(doctorEntity);

		return doctorFormDto;
	}

	@Auditable(actionType = AuditingActionTypeEnum.PACIENTE_CREADO)
	public PacienteEntity crearPaciente(PacienteEntity pacienteEntity) {
		registroDao.guardarPaciente(pacienteEntity);
		return pacienteEntity;
	}

	public EntidadMedicaFormDto crearClinica(EntidadMedicaFormDto entidadMedicaFormDto) {

		EntidadEntity entidadEntity = new EntidadEntity();
		entidadEntity.setCalle(entidadMedicaFormDto.getCalle());
		entidadEntity.setCodigoPostal(entidadMedicaFormDto.getCodigoPostal());
		entidadEntity.setNombre(entidadMedicaFormDto.getNombre());
		entidadEntity.setNumero(entidadMedicaFormDto.getNumero());
		entidadEntity.setRfc(entidadMedicaFormDto.getRfc());
		entidadEntity.setTelefono(entidadMedicaFormDto.getTelefono());
		entidadEntity.setTipo(entidadMedicaFormDto.getTipo().toString());
		entidadEntity.setIdAdministrador(entidadMedicaFormDto.getAdministrador().getIdUser());

		registroDao.guardarEntidad(entidadEntity);

		if (entidadMedicaFormDto.getModulos() != null) {

			List<ModuloContratadoEntity> modulos = entidadMedicaFormDto.getModulos();

			for (ModuloContratadoEntity modulo : modulos) {
				modulo.setIdEntidad(entidadEntity.getIdEntidad());
				modulo.setFechaFin(entidadMedicaFormDto.getFechaFin());
				modulo.setFechaInicio(entidadMedicaFormDto.getFechaInicio());
				modulo.setPrecio(2500);
				registroDao.guardarModuloContratado(modulo);
			}
		}

		return entidadMedicaFormDto;
	}

	private UsuarioEntity crearUsuario(UsuarioBaseFormDto usuarioBaseFormDto, TipoUsuarioEnum tipoUsuarioEnum) {

		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setApPaterno(usuarioBaseFormDto.getApPaterno());
		usuarioEntity.setApMaterno(usuarioBaseFormDto.getApMaterno());
		usuarioEntity.setNombre(usuarioBaseFormDto.getNombre());
		usuarioEntity.setEmail(usuarioBaseFormDto.getEmail());
		usuarioEntity.setFechaNacimiento(usuarioBaseFormDto.getFechaNacimiento());
		usuarioEntity.setPassword(usuarioBaseFormDto.getPassword());
		usuarioEntity.setTipo(tipoUsuarioEnum.toString());

		usuariosDao.crearUsuario(usuarioEntity);

		usuarioEntity.setPassword("");
		return usuarioEntity;
	}
}
