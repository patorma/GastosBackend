package com.patricio.contreras.GastosBackend.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;

public interface ITipoGastoService {

	 public List<TipoGasto> findAll();
	 
	 public Page<TipoGasto> findAll(Pageable pageable);
	 
	 public TipoGasto findById(Long id);
	 
	 public TipoGasto save(TipoGasto tipo);
	 
	 public void delete(Long id);
}
