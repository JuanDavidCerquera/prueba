package com.prueba.prueba.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.Dto.ApiResponseDto;
import com.prueba.prueba.Entity.Clientes;
import com.prueba.prueba.IService.IClientesService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/clientes")
public class ClientesController extends ABaseController<Clientes, IClientesService> {

	public ClientesController(IClientesService service) {
		super(service, "clientes");
	}
	@GetMapping("/filter/{nombre}/{ciudad}")
	private ResponseEntity<ApiResponseDto<List<Clientes>>> getByFilter(@PathVariable(required = false) String nombre, @PathVariable(required = false) String ciudad) {
		try {
		return ResponseEntity.ok(new ApiResponseDto<List<Clientes>>("Datos Obtenidos", service.getByFilter(nombre, ciudad), true));
		}catch(Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, null));
		}
	}

}
