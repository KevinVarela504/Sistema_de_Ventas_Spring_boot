package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Direccion;
import edu.unah.poo.model.Lista;
import edu.unah.poo.model.Pedido;
import edu.unah.poo.repository.RepositoryPedido;

@Service
public class ServicePedido {
	
	@Autowired
	private RepositoryPedido repositoryPedido;
	
	
	public void crearPedido(Pedido pedido) {
		this.repositoryPedido.save(pedido);
			
		}
	
	public Pedido buscarPedido(int id) {
		return this.repositoryPedido.findById(id);
	
	
	}
	
	public void eliminarPedido(Pedido pedido) {
		this.repositoryPedido.delete(pedido);
	}
	
	public List<Pedido> obtenerListasPedidos() {
		return this.repositoryPedido.findAll();
	}
		

}
