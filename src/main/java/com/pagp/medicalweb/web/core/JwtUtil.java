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

	/**
	 * Tries to parse specified String as a JWT token. If successful, returns
	 * User object with username, id and role prefilled (extracted from token).
	 * If unsuccessful (token is invalid or not containing all required user
	 * properties), simply returns null.
	 *
	 * @param token
	 *            the JWT token to parse
	 * @return the User object extracted from specified token or null if a token
	 *         is invalid.
	 */
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

	/**
	 * Generates a JWT token containing username as subject, and userId and role
	 * as additional claims. These properties are taken from the specified User
	 * object. Tokens validity is infinite.
	 *
	 * @param u
	 *            the user for which the token will be generated
	 * @return the JWT token
	 */
	public String generateToken(JwtUserDto u) {
		Claims claims = Jwts.claims().setSubject(u.getUsername());
		claims.put("userId", u.getId() + "");
		claims.put("role", u.getRole());
		claims.put("idEntidad", u.getIdEntidad());
		claims.put("modulos", u.getModulosActivos());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}