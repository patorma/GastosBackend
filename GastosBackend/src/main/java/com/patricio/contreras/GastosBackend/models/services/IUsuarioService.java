package com.patricio.contreras.GastosBackend.models.services;

import com.patricio.contreras.GastosBackend.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
