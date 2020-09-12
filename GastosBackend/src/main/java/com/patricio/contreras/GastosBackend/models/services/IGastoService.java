package com.patricio.contreras.GastosBackend.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.patricio.contreras.GastosBackend.models.entity.Ciudad;
import com.patricio.contreras.GastosBackend.models.entity.Gasto;
import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;


public interface IGastoService {
	
   public List<Gasto> findAll();	
   
   //esto es para mostrar por paginacion los gatos
   public Page<Gasto> findAll(Pageable pageable);
   
   public Gasto findById(Long id);
   
   public Gasto save(Gasto gasto);
   
   public void delete(Long id);
   
   public List<TipoGasto> findAllTipos();
   
   public List<Ciudad> findAllCiudades();
   
   

}

