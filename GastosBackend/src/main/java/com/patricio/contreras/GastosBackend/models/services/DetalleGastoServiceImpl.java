package com.patricio.contreras.GastosBackend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patricio.contreras.GastosBackend.models.dao.IDetalleGastoDao;
import com.patricio.contreras.GastosBackend.models.entity.DetalleGasto;
import com.patricio.contreras.GastosBackend.models.entity.Gasto;
import com.patricio.contreras.GastosBackend.models.entity.Local;
import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;

@Service
public class DetalleGastoServiceImpl implements IDetalleGastoService{
	
	@Autowired
	private IDetalleGastoDao detalleGastoDao;

	@Override
	@Transactional(readOnly = true)
	public List<DetalleGasto> findAll() {
		
		return detalleGastoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<DetalleGasto> findAll(Pageable pageable) {
		
		return detalleGastoDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public DetalleGasto findById(Long id) {
		
		return detalleGastoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DetalleGasto save(DetalleGasto detalle) {
		
		return detalleGastoDao.save(detalle);
	}

	@Override
	@Transactional
	public void delete(Long id) {
	
		detalleGastoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoGasto> findAllTipos() {
		
		return detalleGastoDao.findAllTipos();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Local> findAllLocales() {
	
		return detalleGastoDao.findAllLocales();
	}

	@Override
	public List<Gasto> findAllGastos() {
		
		return detalleGastoDao.findAllGastos();
	}

}
