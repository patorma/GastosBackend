package com.patricio.contreras.GastosBackend.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.patricio.contreras.GastosBackend.models.entity.Ciudad;
import com.patricio.contreras.GastosBackend.models.entity.Gasto;
import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;

public interface IGastoDao extends JpaRepository<Gasto, Long>{
	
	@Query("from TipoGasto")
	public List<TipoGasto> findAllTipos();
	
	@Query("from Gasto")
	public List<Ciudad> findAllCiudad();

}
