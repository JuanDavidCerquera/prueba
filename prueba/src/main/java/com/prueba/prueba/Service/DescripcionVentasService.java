package com.prueba.prueba.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.Entity.DescripcionVentas;
import com.prueba.prueba.IRepository.IBaseRepository;
import com.prueba.prueba.IRepository.IDescripcionVentasRepository;
import com.prueba.prueba.IService.IDescripcionVentasService;
@Service
public class DescripcionVentasService extends ABaseService<DescripcionVentas> implements IDescripcionVentasService{

	@Override
	protected IBaseRepository<DescripcionVentas, Long> repository() {
		return repo;
	}

	@Autowired
	private IDescripcionVentasRepository repo;
}
