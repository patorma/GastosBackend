package com.patricio.contreras.GastosBackend.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.patricio.contreras.GastosBackend.models.entity.Local;

public interface ILocalService {
	
	public List<Local> findAll();
	
	public Page<Local> findAll(Pageable pageable);
	
	public Local findById(Long id);
	
	public Local save(Local local);
	
	public void delete(Long id);
	
}
