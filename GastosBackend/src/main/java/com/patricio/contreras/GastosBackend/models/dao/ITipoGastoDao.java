package com.patricio.contreras.GastosBackend.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;

public interface ITipoGastoDao extends JpaRepository<TipoGasto,Long> {

}
