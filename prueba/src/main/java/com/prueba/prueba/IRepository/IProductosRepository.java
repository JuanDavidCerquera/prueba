package com.prueba.prueba.IRepository;

import org.springframework.stereotype.Repository;

import com.prueba.prueba.Entity.Productos;


@Repository
public interface IProductosRepository extends IBaseRepository<Productos, Long>{

}
