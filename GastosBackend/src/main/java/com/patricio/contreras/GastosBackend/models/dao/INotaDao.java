package com.patricio.contreras.GastosBackend.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patricio.contreras.GastosBackend.models.entity.Nota;

public interface INotaDao extends JpaRepository<Nota, Long> {

}
