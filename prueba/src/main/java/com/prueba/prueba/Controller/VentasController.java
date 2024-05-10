package com.prueba.prueba.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.Entity.Ventas;
import com.prueba.prueba.IService.IVentasService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/ventas")
public class VentasController extends ABaseController<Ventas, IVentasService> {

	public VentasController(IVentasService service) {
		super(service, "Ventas");
	}

}
