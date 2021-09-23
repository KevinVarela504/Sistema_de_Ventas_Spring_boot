package edu.unah.poo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	private int idCliente;
	private String nombre;
	private String correo;
	private int telefono;
	private float limiteCredito;
	
	@OneToMany(mappedBy="cliente",fetch=FetchType.EAGER)
	private Set<Direccion> direccion;


	
	@OneToMany(mappedBy="cliente",fetch=FetchType.EAGER)
	private Set<Pedido> pedido;
	
	public Cliente() {}
	
	public Cliente(int idCliente, String nombre, String correo, int telefono, float limiteCredito) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.limiteCredito = limiteCredito;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public float getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	
	
	
	
	
	
}
