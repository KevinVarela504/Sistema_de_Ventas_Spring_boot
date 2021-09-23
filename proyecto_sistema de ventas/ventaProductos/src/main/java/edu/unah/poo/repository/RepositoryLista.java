package edu.unah.poo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.unah.poo.model.Lista;

public interface RepositoryLista extends JpaRepository<Lista,Integer> {

	public Lista findById(int id);
	
	
}
