package com.patricio.contreras.GastosBackend.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patricio.contreras.GastosBackend.models.entity.Ciudad;

public interface ICiudadDao extends JpaRepository<Ciudad, Long>{

}
