package com.prueba.prueba.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.Entity.Ventas;
import com.prueba.prueba.IRepository.IBaseRepository;
import com.prueba.prueba.IRepository.IVentasRepository;
import com.prueba.prueba.IService.IVentasService;

@Service
public class VentasService extends ABaseService<Ventas> implements IVentasService{

	@Override
	protected IBaseRepository<Ventas, Long> repository() {
		return repo;
	}
	
	@Autowired
	private IVentasRepository repo;

}
