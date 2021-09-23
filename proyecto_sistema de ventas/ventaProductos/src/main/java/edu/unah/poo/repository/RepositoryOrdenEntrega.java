package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.unah.poo.model.OrdenEntrega;

public interface RepositoryOrdenEntrega extends JpaRepository<OrdenEntrega,Integer> {

	public OrdenEntrega findById(int id);
}
