package com.prueba.prueba.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.Entity.DescripcionVentas;
import com.prueba.prueba.IService.IDescripcionVentasService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/descripcion_ventas")
public class DescripcionVentasController extends ABaseController<DescripcionVentas, IDescripcionVentasService> {

	public DescripcionVentasController(IDescripcionVentasService service) {
		super(service, "DescripcionVentas");
	}

}