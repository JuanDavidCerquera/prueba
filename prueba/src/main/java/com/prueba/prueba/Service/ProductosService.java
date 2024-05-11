package com.prueba.prueba.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.Entity.Productos;
import com.prueba.prueba.IRepository.IBaseRepository;
import com.prueba.prueba.IRepository.IProductosRepository;
import com.prueba.prueba.IService.IProductosService;


@Service
public class ProductosService extends ABaseService<Productos> implements IProductosService {

	@Override
	protected IBaseRepository<Productos, Long> repository() {
		return repo;
	}
	
	@Autowired
	private IProductosRepository repo;

	@Override
	public List<Productos> getByFilter(String nombre, Boolean estado) {
		return repo.getByFilter(nombre, estado);
	}

}
