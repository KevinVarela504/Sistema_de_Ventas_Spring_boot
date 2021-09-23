package edu.unah.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="distribucion")
@IdClass(IdDistribucion.class)
public class Distribucion implements Serializable{

	@Id
	private LocalDate fecha;
	@Id
	private int idProvedor;
	@Id
	private int idProducto;
	
	@ManyToOne
	@JoinColumn(name="idProvedor", referencedColumnName="idProvedor", insertable = false, updatable = false)
	@JsonBackReference
	private Provedor provedor;
	
	@ManyToOne
	@JoinColumn(name="idProducto", referencedColumnName="idProducto", insertable = false, updatable = false)
	@JsonBackReference
	private Producto producto;

	public Distribucion() {}
	
	public Distribucion(LocalDate fecha, int idProvedor, int idProducto, Provedor provedor, Producto producto) {
		super();
		this.fecha = fecha;
		this.idProvedor = idProvedor;
		this.idProducto = idProducto;
		this.provedor = provedor;
		this.producto = producto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getIdProvedor() {
		return idProvedor;
	}

	public void setIdProvedor(int idProvedor) {
		this.idProvedor = idProvedor;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	
	

	
}