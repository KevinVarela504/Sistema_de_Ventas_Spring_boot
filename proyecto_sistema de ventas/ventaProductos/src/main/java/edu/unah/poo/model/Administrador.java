package edu.unah.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
public class Administrador {
	
	@Id
	private int idAdministrador;
	private String usuario;
	private String contrasenia;
	private String rol;
	
	
	public Administrador() {}


	public Administrador(int idAdministrador, String usuario, String contrasenia, String rol) {
		super();
		this.idAdministrador = idAdministrador;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.rol = rol;
	}


	public int getIdAdministrador() {
		return idAdministrador;
	}


	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
	

}
