package com.patricio.contreras.GastosBackend.models.dao;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.patricio.contreras.GastosBackend.models.entity.Gasto;
import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;

public interface ITipoGastoDao extends JpaRepository<TipoGasto, Long>{
	
	
	//public List<Gasto> findAllById(Long id);

}
