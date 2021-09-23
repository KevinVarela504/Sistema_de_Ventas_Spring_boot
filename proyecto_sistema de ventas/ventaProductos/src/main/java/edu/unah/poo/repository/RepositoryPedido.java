package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.unah.poo.model.Pedido;

public interface RepositoryPedido extends JpaRepository<Pedido,Integer>{

	public Pedido findById(int id);
}
