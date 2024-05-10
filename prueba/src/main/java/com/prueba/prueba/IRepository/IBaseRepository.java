package com.prueba.prueba.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.prueba.Entity.ABaseEntity;


public interface IBaseRepository<T extends ABaseEntity, ID> extends JpaRepository<T, Long>{

}
