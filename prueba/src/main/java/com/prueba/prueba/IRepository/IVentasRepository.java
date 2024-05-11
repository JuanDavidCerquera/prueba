package com.prueba.prueba.IRepository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.prueba.Entity.Ventas;

@Repository
public interface IVentasRepository extends IBaseRepository<Ventas, Long> {

	@Query(value = "SELECT v.*\r\n"
			+ "FROM ventas v\r\n"
			+ "INNER JOIN clientes c ON v.cliente_id = c.id\r\n"
			+ "WHERE v.fecha_venta "
			+ "BETWEEN :fechaInicio AND :fechaFin\r\n"
			+ "OR (lower(c.nombre) LIKE lower(concat('%', :nombre,'%')))", nativeQuery = true)
	List<Ventas> getByFilter(@Param ("nombre") String nombre, @Param("fechaInicio") LocalDateTime fechaInicio,@Param("fechaFin") LocalDateTime fechaFin );
}
