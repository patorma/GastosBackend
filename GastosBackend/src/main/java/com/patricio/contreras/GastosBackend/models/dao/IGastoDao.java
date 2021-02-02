package com.patricio.contreras.GastosBackend.models.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.patricio.contreras.GastosBackend.models.entity.Gasto;



public interface IGastoDao extends JpaRepository<Gasto, Long>{
	
	/*@Query("from TipoGasto")
	public List<TipoGasto> findAllTipos();*/
	
	/*@Query("from Tipos")
	public List<Tipos> findAllTipos();*/

}
