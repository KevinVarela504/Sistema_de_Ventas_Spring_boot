package edu.unah.poo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ordenentrega")
public class OrdenEntrega {
	@Id
	private int idOrdenEntrega;
	private LocalDate fechaCreacion;
	private  LocalDate fechaEntrega;
	private int idEmpleado;
	private int idPedido;

	
	@ManyToOne
	@JoinColumn(name="idEmpleado",referencedColumnName="idEmpleado",insertable = false, updatable = false)
	@JsonBackReference
	private Empleado empleado;
	
	
	@OneToOne
	@JoinColumn(name="idPedido",referencedColumnName="idPedido",insertable = false, updatable = false)
	private Pedido pedido;
	
	
	public OrdenEntrega() {}


	public OrdenEntrega(int idOrdenEntrega, LocalDate fechaCreacion, LocalDate fechaEntrega, int idEmpleado,
			int idPedido, Empleado empleado, Pedido pedido) {
		super();
		this.idOrdenEntrega = idOrdenEntrega;
		this.fechaCreacion = fechaCreacion;
		this.fechaEntrega = fechaEntrega;
		this.idEmpleado = idEmpleado;
		this.idPedido = idPedido;
		this.empleado = empleado;
		this.pedido = pedido;
	}


	public int getIdOrdenEntrega() {
		return idOrdenEntrega;
	}


	public void setIdOrdenEntrega(int idOrdenEntrega) {
		this.idOrdenEntrega = idOrdenEntrega;
	}


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}


	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	public int getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	

	


	
	
}
