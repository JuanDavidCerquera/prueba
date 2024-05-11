package com.prueba.prueba.IService;

import java.time.LocalDateTime;
import java.util.List;


import com.prueba.prueba.Entity.Ventas;

public interface IVentasService extends IBaseService<Ventas>{

	List<Ventas> getByFilter(String nombreCliente, LocalDateTime fechaInicio,LocalDateTime fechaFin );
}
