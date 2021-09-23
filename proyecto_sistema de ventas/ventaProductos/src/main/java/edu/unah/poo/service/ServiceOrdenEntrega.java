package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Cliente;
import edu.unah.poo.model.OrdenEntrega;
import edu.unah.poo.repository.RepositoryOrdenEntrega;

@Service
public class ServiceOrdenEntrega {

	
	@Autowired
	RepositoryOrdenEntrega repositoryOrdenEntrega;
	
	
	public void crearOrdenEntrega(OrdenEntrega ordenEntrega) {
		this.repositoryOrdenEntrega.save(ordenEntrega);
			
		}
	
	public void eliminarOrdenEntrega(OrdenEntrega ordenEntrega) {
		this.repositoryOrdenEntrega.delete(ordenEntrega);
	}
	
	public List<OrdenEntrega> obtenerOrdenesEntrega() {
		return this.repositoryOrdenEntrega.findAll();
	}
	
	public OrdenEntrega buscarOrdenEntrega(int id) {
		return this.repositoryOrdenEntrega.findById(id);
	
	
	}
	
}
