package com.patricio.contreras.GastosBackend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.patricio.contreras.GastosBackend.models.entity.DetalleGasto;
import com.patricio.contreras.GastosBackend.models.entity.Gasto;
import com.patricio.contreras.GastosBackend.models.entity.Local;
import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;



public interface IDetalleGastoDao extends JpaRepository<DetalleGasto, Long> {
	
	@Query("from TipoGasto")
	public List<TipoGasto> findAllTipos();
	
	
	@Query("from Local")
	public List<Local> findAllLocales();
	
	@Query("from Gasto")
	public List<Gasto> findAllGastos();
	
	

}
