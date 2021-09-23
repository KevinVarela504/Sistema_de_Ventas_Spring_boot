package edu.unah.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {

	@Id
	private int idProducto;
	private String nombre;
	private String unidaMedida;
	private float precio;
	private String descripcion;
	private float cantidadExistente;
	
	public Producto() {}
	
	public Producto(int idProducto, String nombre, String unidaMedida, float precio, String descripcion,
			float cantidadExistente) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.unidaMedida = unidaMedida;
		this.precio = precio;
		this.descripcion = descripcion;
		this.cantidadExistente = cantidadExistente;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidaMedida() {
		return unidaMedida;
	}

	public void setUnidaMedida(String unidaMedida) {
		this.unidaMedida = unidaMedida;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getCantidadExistente() {
		return cantidadExistente;
	}

	public void setCantidadExistente(float cantidadExistente) {
		this.cantidadExistente = cantidadExistente;
	}
	
	
	
	
	
	
}