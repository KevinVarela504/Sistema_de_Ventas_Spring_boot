package edu.unah.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="direccion")
public class Direccion {

	@Id
	private int idDireccion;
	private String direccionFisica;
	private String  direccionDespacho;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	@JsonBackReference
	private Cliente cliente;
	
	public Direccion() {}

	public Direccion(int idDireccion, String direccionFisica, String direccionDespacho, Cliente cliente) {
		super();
		this.idDireccion = idDireccion;
		this.direccionFisica = direccionFisica;
		this.direccionDespacho = direccionDespacho;
		this.cliente = cliente;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getDireccionFisica() {
		return direccionFisica;
	}

	public void setDireccionFisica(String direccionFisica) {
		this.direccionFisica = direccionFisica;
	}

	public String getDireccionDespacho() {
		return direccionDespacho;
	}

	public void setDireccionDespacho(String direccionDespacho) {
		this.direccionDespacho = direccionDespacho;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
