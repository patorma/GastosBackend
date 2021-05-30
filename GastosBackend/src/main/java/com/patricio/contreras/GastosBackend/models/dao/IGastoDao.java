package com.patricio.contreras.GastosBackend.models.dao;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.patricio.contreras.GastosBackend.models.entity.Gasto;
import com.patricio.contreras.GastosBackend.models.entity.Local;
import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;

import org.springframework.data.jpa.repository.Query;


public interface IGastoDao extends JpaRepository<Gasto, Long>{
	
	/*@Query("from TipoGasto")
	public List<TipoGasto> findAllTipos();*/
	
	@Query(value ="SELECT SUM(valor)  FROM Gastos ", nativeQuery = true)
	public int valor2();
	
	@Query(value="SELECT COUNT(nombre) FROM Gastos",nativeQuery = true)
	public int cantidad();
	
	@Query(value="SELECT SUM(g.valor) FROM Gastos g WHERE MONTH(g.fecha_gasto) = ?1 AND YEAR(g.fecha_gasto) = ?2",nativeQuery = true)
	public int showTotalGastoByFecha(int mes,int año);
	
	@Query("from TipoGasto")
	public List<TipoGasto> findAllTipos();
	
	@Query("from Local")
	public List<Local> findAllLocales();

}
