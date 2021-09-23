package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Cliente;
import edu.unah.poo.model.Lista;
import edu.unah.poo.repository.RepositoryCliente;

@Service
public class ServiceCliente {
	
	@Autowired
	RepositoryCliente repositoryCliente;
	
	public void crearCliente(Cliente cliente) {
		this.repositoryCliente.save(cliente);
			
		}
		
		
		public List<Cliente> obtenerCliente() {
			return this.repositoryCliente.findAll();
		}
		
	
		public Cliente buscarCliente(int id) {
			return this.repositoryCliente.findById(id);
		
		
		}
		
		public void eliminarCliente(Cliente cliente) {
			this.repositoryCliente.delete(cliente);
		}
		
	public void actualizarNombreCliente(String nombre, int idCliente) {
			
			this.repositoryCliente.actualizarNombreCliente(nombre, idCliente);
		}
	
	
	public void actualizarCorreoCliente(String correo, int idCliente) {
		
		this.repositoryCliente.actualizarCorreoCliente(correo, idCliente);
	}
	
	
	public void actualizarTelefonoCliente(int telefono, int idCliente) {
		
		this.repositoryCliente.actualizarTelefonoCliente(telefono, idCliente);
	}
	
	
	public void actualizarLimiteCreditoCliente(float limite, int idCliente) {
		
		this.repositoryCliente.actualizarLimiteCreditoCliente(limite, idCliente);
	}

}
