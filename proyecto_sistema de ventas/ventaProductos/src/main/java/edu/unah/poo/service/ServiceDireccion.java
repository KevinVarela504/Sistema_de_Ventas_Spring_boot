package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Cliente;
import edu.unah.poo.model.Direccion;
import edu.unah.poo.repository.RepositoryDireccion;

@Service
public class ServiceDireccion {

	@Autowired
	RepositoryDireccion repositoryDireccion;
	
	public void crearDireccion(Direccion direccion) {
		this.repositoryDireccion.save(direccion);
			
		}
		
		
		public List<Direccion> obtenerDireccion() {
			return this.repositoryDireccion.findAll();
		}
		
	
		public Direccion buscarDireccion(int id) {
			return this.repositoryDireccion.findById(id);
		
		
		}
		
		public void eliminarDireccion(Direccion direccion) {
			this.repositoryDireccion.delete(direccion);
		}
		
}
