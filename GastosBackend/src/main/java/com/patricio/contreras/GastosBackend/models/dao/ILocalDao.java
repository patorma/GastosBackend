package com.patricio.contreras.GastosBackend.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patricio.contreras.GastosBackend.models.entity.Local;

public interface ILocalDao extends JpaRepository<Local,Long> {

}
