package edu.unah.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdDistribucion implements Serializable {

	private LocalDate fecha;
	private int idProvedor;
	private int idProducto;
	
	public IdDistribucion() {}
	
	
	
	
	public IdDistribucion(LocalDate fecha, int idProvedor, int idProducto) {
		super();
		this.fecha = fecha;
		this.idProvedor = idProvedor;
		this.idProducto = idProducto;
	}




	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdDistribucion) {
			IdDistribucion tmpid = (IdDistribucion)obj;
			if(this.idProducto == tmpid.getIdProducto()
				&& this.idProvedor == tmpid.getIdProvedor()
				&& this.fecha.compareTo(tmpid.getFecha())==0) {
				return true;
			}else 
				return false;
		}else return false;
		
	}
	
	
	public int hashCode() {
		return (int) this.fecha.hashCode()+this.idProducto+this.idProvedor;
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