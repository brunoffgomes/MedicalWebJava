package com.pagp.medicalweb.web.core;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CORSFilter extends OncePerRequestFilter {
	static final String ORIGIN = "Origin";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (request.getHeader(ORIGIN).equals("http://127.0.0.1:8888")) {
			response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8888");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
		}
		if (request.getMethod().equals("OPTIONS")) {
			try {
				response.getWriter().print("OK");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}
}
