package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Direccion;

public interface RepositoryDireccion extends JpaRepository<Direccion,Integer> {
	public Direccion findById(int id);

}
