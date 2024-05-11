package com.prueba.prueba.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.Entity.Clientes;
import com.prueba.prueba.IRepository.IBaseRepository;
import com.prueba.prueba.IRepository.IClienteRepository;
import com.prueba.prueba.IService.IClientesService;


@Service
public class ClientesService extends ABaseService<Clientes> implements IClientesService{

	@Override
	protected IBaseRepository<Clientes, Long> repository() {
		return repo;
	}

	@Autowired
	private IClienteRepository repo;

	@Override
	public List<Clientes> getByFilter(String nombre, String ciudad, Boolean estado ) {
		return repo.getByFilter(nombre, ciudad,estado);
	}
}
