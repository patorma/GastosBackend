package com.patricio.contreras.GastosBackend.auth;

public class JwtConfig {
	
	// static significa que se puede accder de forma directa porque es un atributo de la
	// clase no del objeto. Se accede de la siguiente manera: el nombre de la clase.el_atributo 
	// y final no se puede cambiar el valor
	
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";

}
