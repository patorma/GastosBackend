package com.patricio.contreras.GastosBackend.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.patricio.contreras.GastosBackend.models.entity.Nota;

public interface INotaService {
	
	public List<Nota> findAll();
	
	public Page<Nota> findAll(Pageable pageable);
	
	public Nota findById(Long id);
	
	public Nota save(Nota nota);
	
	public void delete(Long id);

}
