package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Distribucion;
import edu.unah.poo.model.IdDistribucion;

public interface RepositoryDistribucion extends JpaRepository<Distribucion,IdDistribucion>{

	
	
}
