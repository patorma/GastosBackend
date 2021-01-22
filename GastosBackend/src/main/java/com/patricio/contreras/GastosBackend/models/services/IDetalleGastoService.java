package com.patricio.contreras.GastosBackend.models.services;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.patricio.contreras.GastosBackend.models.entity.DetalleGasto;


public interface IDetalleGastoService {
	
	
	public List<DetalleGasto> findAll();	
	
	public Page<DetalleGasto> findAll(Pageable pageable);
	
	public DetalleGasto findById(Long id);
	
	public DetalleGasto save(DetalleGasto detalle);
	
	public void delete(Long id);
	
	//public List<Gasto> findAllGastos();
	
	

}
