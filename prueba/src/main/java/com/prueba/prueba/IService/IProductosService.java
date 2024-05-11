package com.prueba.prueba.IService;

import java.util.List;


import com.prueba.prueba.Entity.Productos;

public interface IProductosService extends IBaseService<Productos>{

	List<Productos> getByFilter(String nombre, Boolean estado);
	List<Productos> getByCantidad();
}
