package com.patricio.contreras.GastosBackend.models.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import com.patricio.contreras.GastosBackend.models.entity.Usuario;

public interface IUsuarioService  {
	
	public List<Usuario> findAll();	
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id);
	
	
	
	public Usuario findByUsername(String username);

}
