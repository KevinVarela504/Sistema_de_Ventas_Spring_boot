package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Direccion;
import edu.unah.poo.model.Lista;
import edu.unah.poo.model.OrdenEntrega;
import edu.unah.poo.repository.RepositoryLista;

@Service
public class ServiceLista {

	@Autowired
	RepositoryLista  repositoryLista;
	
	public void guardarListaProductos(Lista lista) {
	this.repositoryLista.save(lista);
			
		}
		
		
		public List<Lista> obtenerListasProductos() {
			return this.repositoryLista.findAll();
		}
		
	
		public Lista buscarLista(int id) {
			return this.repositoryLista.findById(id);
		
		
		}
		
		public void eliminarproductoLista(Lista lista) {
			this.repositoryLista.delete(lista);
		}
	
}
