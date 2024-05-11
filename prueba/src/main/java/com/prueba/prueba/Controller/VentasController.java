package com.prueba.prueba.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.Dto.ApiResponseDto;
import com.prueba.prueba.Dto.VentasFilterDto;
import com.prueba.prueba.Entity.Ventas;
import com.prueba.prueba.IService.IVentasService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/ventas")
public class VentasController extends ABaseController<Ventas, IVentasService> {

	public VentasController(IVentasService service) {
		super(service, "Ventas");
	}
	
	  @PostMapping("/filter")
	    private ResponseEntity<ApiResponseDto<List<Ventas>>> getByFilter(@RequestBody VentasFilterDto filterRequest) {
	        try {
	            return ResponseEntity.ok(new ApiResponseDto<>("Datos Obtenidos",service.getByFilter(filterRequest.getNombre(), filterRequest.getFechaInicio(),filterRequest.getFechaFin()), true));
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
	        }
	    }

}
