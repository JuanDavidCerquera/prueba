package com.prueba.prueba.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes extends ABaseEntity{

	@Column(name = "tipo_identificaion")
	private String tipo_identificaion;

	@Column(name = "identificacion" )
	private String identificacion;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name =  "apellido")
	private String apellido;

	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name= "ciudad")
	private String ciudad;

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getTipo_identificaion() {
		return tipo_identificaion;
	}

	public void setTipo_identificaion(String tipo_identificaion) {
		this.tipo_identificaion = tipo_identificaion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	
}
