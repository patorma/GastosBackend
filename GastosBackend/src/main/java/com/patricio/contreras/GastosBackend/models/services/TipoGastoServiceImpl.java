package com.patricio.contreras.GastosBackend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patricio.contreras.GastosBackend.models.dao.ITipoGastoDao;
import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;

@Service
public class TipoGastoServiceImpl implements ITipoGastoService {
	
	@Autowired
	private ITipoGastoDao tipoGastoDao;

	@Override
	@Transactional(readOnly = true)
	public List<TipoGasto> findAll() {
		
		return tipoGastoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TipoGasto> findAll(Pageable pageable) {
		
		return tipoGastoDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoGasto findById(Long id) {
		
		return tipoGastoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public TipoGasto save(TipoGasto tipoGasto) {
		
		return tipoGastoDao.save(tipoGasto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		tipoGastoDao.deleteById(id);
		
	}

}
