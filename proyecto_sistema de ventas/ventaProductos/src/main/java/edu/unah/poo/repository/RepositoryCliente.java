package edu.unah.poo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.unah.poo.model.Cliente;

public interface RepositoryCliente extends JpaRepository<Cliente,Integer> {
	
	public Cliente findById(int id);
	
	 @Transactional
	 @Modifying
	 @Query(value="update cliente set nombre=?1  where idCliente=?2" , nativeQuery=true)
public void actualizarNombreCliente(String nombre , int idCliente);
	 
	 
	 @Transactional
	 @Modifying
	 @Query(value="update cliente set correo=?1  where idCliente=?2" , nativeQuery=true)
public void actualizarCorreoCliente(String correo , int idCliente);
	 
	 @Transactional
	 @Modifying
	 @Query(value="update cliente set telefono=?1  where idCliente=?2" , nativeQuery=true)
public void actualizarTelefonoCliente(int telefono , int idCliente);
	 
	 @Transactional
	 @Modifying
	 @Query(value="update cliente set limiteCredito=?1  where idCliente=?2" , nativeQuery=true)
public void actualizarLimiteCreditoCliente(float limiteCredito , int idCliente);
	 

}
