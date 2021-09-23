package edu.unah.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="provedor")
public class Provedor {

	@Id
	private int idProvedor;
	private String nombre;
	private int telefono;
	private String direccion;
	private String correo;
	private String rtn;
	
	public Provedor() {}
	
	public Provedor(int idProvedor, String nombre, int telefono, String direccion, String correo, String rtn) {
		super();
		this.idProvedor = idProvedor;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.rtn = rtn;
	}

	public int getIdProvedor() {
		return idProvedor;
	}

	public void setIdProvedor(int idProvedor) {
		this.idProvedor = idProvedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRtn() {
		return rtn;
	}

	public void setRtn(String rtn) {
		this.rtn = rtn;
	}
	
	
	
	
	
}