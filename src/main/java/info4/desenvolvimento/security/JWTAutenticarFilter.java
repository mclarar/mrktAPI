package info4.desenvolvimento.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import info4.desenvolvimento.data.UsuarioData;
import info4.desenvolvimento.model.UsuarioModel;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {

	public static final int TOKEN_EXPIRACAO = 600_000;
	public static final String TOKEN_SENHA = "90d268ed-b342-48ff-af59-60f3138f9f6c";

	private final AuthenticationManager authenticationManager;

	public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub

		try {
			UsuarioModel usuario = new ObjectMapper().readValue(request.getInputStream(), UsuarioModel.class);
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException("Falha ao autenticar usuario", e);
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
	
		UsuarioData usuarioData=(UsuarioData) authResult.getPrincipal();
		
		String token = JWT.create().withSubject(usuarioData.getUsername()).withExpiresAt(new Date(System.currentTimeMillis()+TOKEN_EXPIRACAO))
				.sign(Algorithm.HMAC512(TOKEN_SENHA));
		
		response.getWriter().write(token);
		response.getWriter().flush();
	}
}
