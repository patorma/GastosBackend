package com.patricio.contreras.GastosBackend.models.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.patricio.contreras.GastosBackend.models.entity.Gasto;
import org.springframework.data.jpa.repository.Query;


public interface IGastoDao extends JpaRepository<Gasto, Long>{
	
	/*@Query("from TipoGasto")
	public List<TipoGasto> findAllTipos();*/
	
	@Query(value ="SELECT SUM(valor)  FROM Gastos ", nativeQuery = true)
	public int valor2();
	
	@Query(value="SELECT COUNT(nombre) FROM Gastos",nativeQuery = true)
	public int cantidad();

}
