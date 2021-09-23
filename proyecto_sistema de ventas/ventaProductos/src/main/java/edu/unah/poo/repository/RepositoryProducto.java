package edu.unah.poo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.unah.poo.model.Producto;



public interface RepositoryProducto extends JpaRepository<Producto,Integer>{

	public Producto findById(int id);
	
	 @Transactional
	 @Modifying
	 @Query(value="update producto set cantidadExistente=?1  where idProducto=?2" , nativeQuery=true)
public void actualizarcantidadExistente(float cantidadExistente , int idProducto);
	 
}
