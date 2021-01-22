package com.patricio.contreras.GastosBackend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.patricio.contreras.GastosBackend.models.entity.DetalleGasto;
import com.patricio.contreras.GastosBackend.models.entity.Gasto;



public interface IDetalleGastoDao extends JpaRepository<DetalleGasto, Long> {
	
	
	
	
	
	/*@Query("from Gasto")
	public List<Gasto> findAllGastos();
	*/
	

}
