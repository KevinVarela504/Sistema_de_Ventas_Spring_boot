package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Administrador;

public interface RepositoryAdministrador extends JpaRepository<Administrador,Integer> {

	
}
