package com.prueba.prueba.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.prueba.Entity.Productos;


@Repository
public interface IProductosRepository extends IBaseRepository<Productos, Long>{

	
	@Query(value ="    SELECT *\r\n"
			+ "    from productos\r\n"
			+ "    WHERE \r\n"
			+ "    (lower(nombre_producto) LIKE lower(concat('%',:nombre,'%'))) and\r\n"
			+ "	(:estado IS NULL OR estado = :estado);", nativeQuery = true)
	List<Productos> getByFilter(@Param("nombre") String nombre, @Param("estado") Boolean estado);
	
	@Query(value="Select *\r\n"
			+ "From productos\r\n"
			+ "order by cantidad",nativeQuery = true)
	List<Productos> getByCantidad();
}
