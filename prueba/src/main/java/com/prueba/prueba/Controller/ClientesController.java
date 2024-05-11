package com.prueba.prueba.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.Dto.ApiResponseDto;
import com.prueba.prueba.Dto.ClientesFiltroDto;
import com.prueba.prueba.Entity.Clientes;
import com.prueba.prueba.IService.IClientesService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/clientes")
public class ClientesController extends ABaseController<Clientes, IClientesService> {

	public ClientesController(IClientesService service) {
		super(service, "clientes");
	}
    @PostMapping("/filter")
    private ResponseEntity<ApiResponseDto<List<Clientes>>> getByFilter(@RequestBody ClientesFiltroDto filterRequest) {
        try {
            return ResponseEntity.ok(new ApiResponseDto<>("Datos Obtenidos", service.getByFilter(filterRequest.getNombre(), filterRequest.getCiudad(),  filterRequest.getEstado()), true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }

}
