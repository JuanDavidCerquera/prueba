package com.prueba.prueba.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.prueba.prueba.Dto.ApiResponseDto;
import com.prueba.prueba.Entity.ABaseEntity;
import com.prueba.prueba.IService.IBaseService;


public class ABaseController<T extends ABaseEntity, S extends IBaseService<T>>{

	protected S service;
	protected String entityName;
	
	protected ABaseController(S service, String entityName) {
		this.service = service;
		this.entityName = entityName;
	}
	

	@GetMapping
	private ResponseEntity<ApiResponseDto<List<T>>> all() {
		try {
		return ResponseEntity.ok(new ApiResponseDto<List<T>>("Datos Obtenidos", service.all(), true));
		}catch(Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, null));
		}
	}
	@GetMapping("{id}")
	private ResponseEntity<ApiResponseDto<Optional<T>>> findById(@PathVariable Long id) {
		try {
			Optional<T> entity = service.findById(id);
		return ResponseEntity.ok(new ApiResponseDto<Optional<T>>("Datos Obtenidos", entity, true));
		}catch(Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, null));
		}
	}
	
	@PostMapping
	private ResponseEntity<ApiResponseDto<T>> save(@RequestBody T entity) {
		try {
		return ResponseEntity.ok(new ApiResponseDto<T>("Datos Obtenidos", service.save(entity), true));
		}catch(Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, null));
		}
	}
	@PutMapping("{id}")
	private ResponseEntity<ApiResponseDto<T>> update(@PathVariable Long id, @RequestBody T entity) {
		try {
			service.update(entity, id);
		return ResponseEntity.ok(new ApiResponseDto<T>("Datos Obtenidos", null, true));
		}catch(Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, null));
		}
	}
	
	@DeleteMapping("{id}")
	private ResponseEntity<ApiResponseDto<T>> delete(@PathVariable Long id) {
		try {
			service.deleted(id);
		return ResponseEntity.ok(new ApiResponseDto<T>("Datos Obtenidos", null, true));
		}catch(Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, null));
		}
	}
	
}
