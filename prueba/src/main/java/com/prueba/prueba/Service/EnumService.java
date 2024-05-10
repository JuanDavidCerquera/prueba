package com.prueba.prueba.Service;

import org.springframework.stereotype.Service;

import com.prueba.prueba.Enum.TypeDocument;
import com.prueba.prueba.IService.IEnumService;

@Service
public class EnumService implements IEnumService{

	@Override
	public TypeDocument[] getTypeDocument() {
		return TypeDocument.values();
	}

}
