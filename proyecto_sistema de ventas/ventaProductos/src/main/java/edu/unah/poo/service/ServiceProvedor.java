package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Provedor;
import edu.unah.poo.repository.RepositoryProvedor;

@Service
public class ServiceProvedor {

	@Autowired
	RepositoryProvedor repositoryProvedor;
	
	public void crearProvedor(Provedor provedor) {
		this.repositoryProvedor.save(provedor);
			
		}
		
		
		public List<Provedor> obtenerProvedor() {
			return this.repositoryProvedor.findAll();
		}
		
	
		public Provedor buscarProvedor(int id) {
			return this.repositoryProvedor.findById(id);
		
		
		}
}