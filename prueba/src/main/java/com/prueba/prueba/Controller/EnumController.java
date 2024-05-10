package com.prueba.prueba.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.Enum.TypeDocument;
import com.prueba.prueba.IService.IEnumService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("v1/api/enum")
public class EnumController  {

	@Autowired
	private IEnumService service;
	
	@GetMapping
	public TypeDocument[] getTypeDocument() {
		return service.getTypeDocument();
		
	}
}
