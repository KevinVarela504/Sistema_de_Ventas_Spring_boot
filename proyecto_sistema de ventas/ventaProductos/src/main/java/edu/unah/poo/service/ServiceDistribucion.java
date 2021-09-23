package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Distribucion;
import edu.unah.poo.model.IdDistribucion;
import edu.unah.poo.repository.RepositoryDistribucion;

@Service
public class ServiceDistribucion {

	@Autowired 
	RepositoryDistribucion repositoryDistribucion;
	
	public void crearDistribucion(Distribucion distribucion) {
	this.repositoryDistribucion.save(distribucion);
		
	}
	
	
	public List<Distribucion> obtenerDistribucion() {
		return this.repositoryDistribucion.findAll();
	}
	
	public Distribucion buscarDistribucion(IdDistribucion idDistribucion) {
		return this.repositoryDistribucion.getOne(idDistribucion);
	}
}