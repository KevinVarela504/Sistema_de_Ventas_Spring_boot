package edu.unah.poo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	private int idPedido;
	private LocalDate fecha;
	private String direccionCliente;
	
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	@JsonBackReference
	private Cliente cliente;
	
	
	@OneToOne(mappedBy="pedido")
	private OrdenEntrega ordenEntrega;

	public Pedido() {}
	
	public Pedido(int idPedido, LocalDate fecha, String direccionCliente, Cliente cliente) {
		super();
		this.idPedido = idPedido;
		this.fecha = fecha;
		this.direccionCliente = direccionCliente;
		
		this.cliente = cliente;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
	
	
	
	
	
	
}
