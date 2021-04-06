package com.patricio.contreras.GastosBackend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	// aca inyectamos el bean de la clase SpringSecurityConfig llamado
	// passwordEncoder()
	
	@Autowired
	private BCryptPasswordEncoder  passwordEncoder;
	
	// Se debe inyectar el AuthenticationManager
	// AutorizationServer lo use en el login
	// con @Qualifier para elegir que bean inyectar
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
	// Se implementaran tres metodos de configuracion

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

		super.configure(security);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	
		super.configure(clients);
	}

	// Se configura el endpoint del AuthorizationServer se encarga del proceso de autenticacion
	// y de validar el token , cada vez que iniciamos sesion enviamos nuestro usuario y contraseña
	// y si todo sale bien realiza la autenticacion , genera el token se lo entrega al usurio
	// y despues el usuario con ese token puede acceder a las distintas paginas  y recursos de nuestra
	// aplicacion backend para eso se debe validar eso se realiza en endpoints en unas rutas, que maneja 
	// el servidor de autorizacion tanto para el login o autorizacion que genera el token y tambien para el proceso
	// de validacion , validar el token y su firma 
	//  accessTokenConverter almacena datos de autorizacion del usario(maneja datos del token)
	// accessTokenConverter se encarga de traducir los datos del token
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		endpoints.authenticationManager(authenticationManager)
		.tokenStore(tokenStore())// se pasa una instacia del componente que se encarga de almacenar los datos
		.accessTokenConverter(accesTokenConverter());
	}

	@Bean
	public JwtTokenStore tokenStore() {
		
		return new JwtTokenStore(accesTokenConverter());
	}

	// se anota con @Bean para indicar que se va a crear un componente de spring
	//se importa la implementacion de jwt
	// decodifica y codifica datos del token
	@Bean
	public JwtAccessTokenConverter accesTokenConverter() {
		// luego se genera un objeto
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();     
		return jwtAccessTokenConverter;
	}
	

	
	
	

}
