package com.patricio.contreras.GastosBackend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patricio.contreras.GastosBackend.models.dao.IGastoDao;

import com.patricio.contreras.GastosBackend.models.entity.Gasto;
import com.patricio.contreras.GastosBackend.models.entity.Local;
import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;



@Service
public class GastoServiceImpl implements IGastoService {

	@Autowired
	private IGastoDao gastoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Gasto> findAll() {

		return gastoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Gasto> findAll(Pageable pageable) {

		return gastoDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Gasto findById(Long id) {

		return gastoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Gasto save(Gasto gasto) {

		return gastoDao.save(gasto);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		gastoDao.deleteById(id);

	}

	@Override
	@Transactional
	public int valor2() {
		
		return gastoDao.valor2();
	}

	@Override
	@Transactional
	public int cantidad() {
		
		return gastoDao.cantidad();
	}

	@Override
	@Transactional
	public int showTotalGastoByFecha(int mes, int a�o) {
		
		return gastoDao.showTotalGastoByFecha(mes, a�o);
	}

	@Override
	public List<TipoGasto> findAllTipos() {
		
		return gastoDao.findAllTipos();
	}

	@Override
	public List<Local> findAllLocales() {
		
		return gastoDao.findAllLocales();
	}

	



}
