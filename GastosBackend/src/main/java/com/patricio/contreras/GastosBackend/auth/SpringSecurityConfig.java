package com.patricio.contreras.GastosBackend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	// al inyectar la interface va abuscar una implementacion concreta que sea de tipo
	//  UserDetailsService y como hay una sola inyecta UsuarioService
	@Autowired
	private UserDetailsService usuarioService;
	
	// la abnotacion @Bean permite que sea compartido por las clases de Spring
	// se intectara con autowired ya que estara almacenado en el contenedor de spring 
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		// se retorna una instacia de BCryptPasswordEncoder
		// luego hay que guardar el objeto que devuelve en uncomponente de spring en un Bean
		
		return new BCryptPasswordEncoder();
	}
	// lo siguiente es registrar en el autentication manager este servicio para 
	// autenticarpara eso sobreescribimos un metodo
   // Va con @Autowired porque se va inyectar por parametro AuthenticationManagerBuilder auth

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// ahora con auth se registra UserDetailsService
		//tambien se va a rncriptar la contraseña
		auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder());
	}
	
	

	
}
