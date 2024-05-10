package com.prueba.prueba.IRepository;

import org.springframework.stereotype.Repository;

import com.prueba.prueba.Entity.Ventas;

@Repository
public interface IVentasRepository extends IBaseRepository<Ventas, Long> {

}
