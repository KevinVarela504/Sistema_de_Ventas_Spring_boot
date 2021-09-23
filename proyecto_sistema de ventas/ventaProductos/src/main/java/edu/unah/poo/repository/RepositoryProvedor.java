package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.unah.poo.model.Provedor;



public interface RepositoryProvedor extends JpaRepository<Provedor,Integer> {
	public Provedor findById(int id);

}
