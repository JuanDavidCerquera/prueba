package com.prueba.prueba.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.prueba.Entity.Clientes;


@Repository
public interface IClienteRepository extends IBaseRepository<Clientes, Long>{

	
	@Query(value="SELECT * \r\n"
	        + "FROM clientes \r\n"
	        + "WHERE \r\n"
	        + "    (LOWER(nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND\r\n"
	        + "    (LOWER(ciudad) LIKE LOWER(CONCAT('%', :ciudad, '%')))", nativeQuery = true)
	List<Clientes> getByFilter(@Param("nombre") String nombre, @Param("ciudad") String ciudad);
}
