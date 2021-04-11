package com.patricio.contreras.GastosBackend.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

// con @Configuration decimos que es de configuracion y con @EnableResourceServer habilitamos el 
// servidor de recursos
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	// De la clase ResourceServerConfigurerAdapter sobreescribimos el metodo
	// configure(HttpSecurity)
	//.anyRequest().authenticated() siempre al final, para todas las rutas(endpoints)que no hayamos
	//asignado permisos
	// Estos son reglas para endpoints por el lado de oauth2
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/gastos","/api/gastos/page/**","/api/notas","/api/notas/page/**").permitAll()
		.antMatchers(HttpMethod.GET,"/api/gastos/{id}","/api/notas/{id}").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.GET,"/api/gastos/filtrarValor/**/**").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST,"/api/gastos","/api/notas").hasRole("ADMIN")
		.antMatchers("/api/gastos/**","/api/notas/**").hasRole("ADMIN")
		.anyRequest().authenticated();
	}
	
	
	

}
