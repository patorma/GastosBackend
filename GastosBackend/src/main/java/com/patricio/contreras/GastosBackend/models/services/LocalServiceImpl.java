package com.patricio.contreras.GastosBackend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patricio.contreras.GastosBackend.models.dao.ILocalDao;
import com.patricio.contreras.GastosBackend.models.entity.Local;

@Service
public class LocalServiceImpl implements ILocalService  {
	
	
	@Autowired
	private ILocalDao localDao;

	@Override
	@Transactional(readOnly = true)
	public List<Local> findAll() {
		
		return localDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Local> findAll(Pageable pageable) {
		
		return localDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Local findById(Long id) {
		
		return localDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Local save(Local local) {
		
		return localDao.save(local);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		localDao.deleteById(id);
		
	}

}
