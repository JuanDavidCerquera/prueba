package com.prueba.prueba.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.prueba.prueba.Entity.ABaseEntity;
import com.prueba.prueba.IRepository.IBaseRepository;
import com.prueba.prueba.IService.IBaseService;



public abstract class ABaseService<T extends ABaseEntity> implements IBaseService<T>{

	protected abstract IBaseRepository<T, Long> repository();
	
	@Override
	public List<T> all() throws Exception {
		return repository().findAll();
	}

	@Override
	public Optional<T> findById(Long id) throws Exception {
		Optional<T> op = repository().findById(id);
		if(op.isEmpty()) {
			throw new Exception("registro no encontrado");
		}
		return op;
	}

	@Override
	public T save(T entity) throws Exception {
		try {
		return repository().save(entity);
		}catch(Exception e) {
			throw new Exception("error al guardar" + e.getMessage());
		}
	}

	@Override
	public void update(T entity, Long id) throws Exception {
		Optional<T> op = repository().findById(id);
		if(op.isEmpty()) {
			throw new Exception("registro no encontrado");
		}
		  T existingEntity = op.get();
		String[] ignoreProperties = {"id"};
		BeanUtils.copyProperties(entity,existingEntity, ignoreProperties);
		
		  
		  repository().save(existingEntity);
	}

	@Override
	public void deleted(Long id) throws Exception {
		repository().deleteById(id);
	}
	@Override
	public void changeState(Long id) throws Exception {
		Optional<T> op = repository().findById(id);
		if(op.isEmpty()) {
			throw new Exception("registro no encontrado");
		}
		  T existingEntity = op.get();
		  existingEntity.setEstado(!existingEntity.getEstado());
		  repository().save(existingEntity);
	}
	

}
