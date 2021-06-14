package com.ust.IQair.jwtfilter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtFilter extends GenericFilterBean{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String header = req.getHeader("authorization");

		if (header == null || !header.startsWith("Bearer ")) {
			throw new ServletException("Invalid Header");
		}

		else {
			if (req.getMethod().equals("OPTION")) {
				resp.setStatus(HttpServletResponse.SC_OK);
				chain.doFilter(request, response);
			}
		}

		String token = header.substring(7);
		Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
		req.setAttribute("claims", claims);
		chain.doFilter(request, response);

	}
}
