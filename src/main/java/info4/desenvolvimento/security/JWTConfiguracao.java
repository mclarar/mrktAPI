package info4.desenvolvimento.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class JWTConfiguracao extends WebSecurityConfigurerAdapter {

//	private static final String[] PUBLIC_ROUTERS= {
//			"/usuarios","/auth/forgot/**"
//	};

	private final UsuarioServiceImp usuarioService;
	private final PasswordEncoder passwordEncoder;

	public JWTConfiguracao(UsuarioServiceImp usuarioService, PasswordEncoder passwordEncoder) {

		this.usuarioService = usuarioService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/login", "/usuario/criarUsuario", "empresa/criarEmpresa", "/criar").permitAll()
				/*
				 * .anyRequest().authenticated()
				 */.and().addFilter(new JWTAutenticarFilter(authenticationManager()))
				.addFilter(new JWTValidarFilter(authenticationManager())).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
//	@Bean
//	org.springframework.web.cors.reactive.CorsConfigurationSource corsConfiguration() {
//		final UrlBasedCorsConfigurationSource source =new UrlBasedCorsConfigurationSource();
//		
//		CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//		source.registerCorsConfiguration("/**", corsConfiguration);
//		
//		return source;
//	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000/"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration.applyPermitDefaultValues());
//		source.registerCorsConfiguration("/**", corsConfiguration);
		return source;
	}
}
