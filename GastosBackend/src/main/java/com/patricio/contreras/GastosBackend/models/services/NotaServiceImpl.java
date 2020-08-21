package com.patricio.contreras.GastosBackend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patricio.contreras.GastosBackend.models.dao.INotaDao;
import com.patricio.contreras.GastosBackend.models.entity.Nota;

@Service
public class NotaServiceImpl implements INotaService {

	@Autowired
	private INotaDao notaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Nota> findAll() {

		return notaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Nota> findAll(Pageable pageable) {

		return notaDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Nota findById(Long id) {

		return notaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Nota save(Nota nota) {

		return notaDao.save(nota);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		notaDao.deleteById(id);

	}

}
