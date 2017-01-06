package com.pagp.medicalweb.web.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pagp.medicalweb.web.core.dto.JwtUserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;

	public JwtUserDto parseToken(String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

			JwtUserDto u = new JwtUserDto();
			u.setUsername(body.getSubject());
			u.setId(Integer.parseInt((String) body.get("userId")));
			u.setRole((String) body.get("role"));
			u.setIdEntidad((int) body.get("idEntidad"));

			return u;

		} catch (JwtException | ClassCastException e) {
			return null;
		}
	}

	public String generateToken(JwtUserDto u) {
		Claims claims = Jwts.claims().setSubject(u.getUsername());
		claims.put("userId", u.getId() + "");
		claims.put("role", u.getRole());
		claims.put("idEntidad", u.getIdEntidad());
		claims.put("modulos", u.getModulosActivos());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}