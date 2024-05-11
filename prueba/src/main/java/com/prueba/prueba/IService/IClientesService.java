package com.prueba.prueba.IService;

import java.util.List;
import com.prueba.prueba.Entity.Clientes;

public interface IClientesService extends IBaseService<Clientes>{

	List<Clientes> getByFilter(String nombre, String ciudad, Boolean estado);
}
