package com.pagp.medicalweb.web.core.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthenticatedUser implements UserDetails {
	/**
	 *
	 */
	private static final long serialVersionUID = 7760153264751314086L;

	private final int id;
	private final String username;
	private final String token;
	private final Integer idEntidad;
	private final Collection<? extends GrantedAuthority> authorities;

	public AuthenticatedUser(int id, String username, String token, Collection<? extends GrantedAuthority> authorities,
			Integer idEntidad) {
		this.id = id;
		this.username = username;
		this.token = token;
		this.authorities = authorities;
		this.idEntidad = idEntidad;
	}

	@JsonIgnore
	public int getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}

	public String getToken() {
		return token;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	public Integer getIdEntidad() {
		return idEntidad;
	}

}