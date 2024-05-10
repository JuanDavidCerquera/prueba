package com.prueba.prueba.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.Entity.Productos;
import com.prueba.prueba.IService.IProductosService;


@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/productos")
public class ProductosController extends ABaseController<Productos, IProductosService>{

	public ProductosController(IProductosService service) {
		super(service, "productos");
	}

}
