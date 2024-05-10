package com.prueba.prueba.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class ABaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)private Long id;
	
	
	@Column(name = "estado", nullable = false)
	private Boolean estado;
	

}
