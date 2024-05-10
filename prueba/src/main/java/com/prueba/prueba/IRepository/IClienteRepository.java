package com.prueba.prueba.IRepository;

import org.springframework.stereotype.Repository;

import com.prueba.prueba.Entity.Clientes;


@Repository
public interface IClienteRepository extends IBaseRepository<Clientes, Long>{

}
