package com.prueba.prueba.IService;

import java.util.List;
import java.util.Optional;

import com.prueba.prueba.Entity.ABaseEntity;


public interface IBaseService<T extends ABaseEntity> {

	List<T> all() throws Exception;
	Optional<T> findById(Long id)throws Exception;
	T save(T entity)throws Exception;
	void update(T entity, Long id)throws Exception;
	void deleted(Long id)throws Exception;
	void changeState(Long id)throws Exception;
	
	
}
