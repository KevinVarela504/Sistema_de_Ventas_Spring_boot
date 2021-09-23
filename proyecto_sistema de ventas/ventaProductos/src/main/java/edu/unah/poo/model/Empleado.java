package edu.unah.poo.model;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {
@Id
private int idEmpleado;
private String nombre;
private int telefono;
private String direccion;


@OneToMany(mappedBy="empleado",fetch=FetchType.EAGER)
private List<OrdenEntrega> ordenEntrega;

public Empleado() {}

public Empleado(int idEmpleado, String nombre, int telefono, String direccion) {
	super();
	this.idEmpleado = idEmpleado;
	this.nombre = nombre;
	this.telefono = telefono;
	this.direccion = direccion;
}

public int getIdEmpleado() {
	return idEmpleado;
}

public void setIdEmpleado(int idEmpleado) {
	this.idEmpleado = idEmpleado;
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



	
	
}
