package com.prueba.prueba.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos extends ABaseEntity{
	
	@Column(name = "nombre_producto")
	private String nombreProducto;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "cantidad")
	private int cantidad;	
	@Column(name = "precio")
	private Double precio;	
	@Column(name = "porcentaje_iva")
	private int porcentajeIva;	
	@Column(name = "porcentaje_descuento")
	private int porcentajeDescuento;
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getPorcentajeIva() {
		return porcentajeIva;
	}
	public void setPorcentajeIva(int porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}
	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	public void setPorcentajeDescuento(int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	

}
