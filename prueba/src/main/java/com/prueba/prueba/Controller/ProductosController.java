package com.prueba.prueba.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.Dto.ApiResponseDto;
import com.prueba.prueba.Dto.ProductofilterDto;
import com.prueba.prueba.Entity.Productos;
import com.prueba.prueba.IService.IProductosService;


@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/productos")
public class ProductosController extends ABaseController<Productos, IProductosService>{

	public ProductosController(IProductosService service) {
		super(service, "productos");
	}

	  @PostMapping("/filter")
	    private ResponseEntity<ApiResponseDto<List<Productos>>> getByFilter(@RequestBody ProductofilterDto filterRequest) {
	        try {
	            return ResponseEntity.ok(new ApiResponseDto<>("Datos Obtenidos",service.getByFilter(filterRequest.getNombre(), filterRequest.getEstado()), true));
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
	        }
	    }
}
