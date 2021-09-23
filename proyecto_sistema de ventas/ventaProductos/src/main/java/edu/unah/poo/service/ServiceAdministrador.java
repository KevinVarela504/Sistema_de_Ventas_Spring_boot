package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Administrador;

import edu.unah.poo.repository.RepositoryAdministrador;



@Service
public class ServiceAdministrador {

	
	@Autowired
	RepositoryAdministrador repositoryAdministrador;
	
	public void crearAdministrador(Administrador administrador) {
		this.repositoryAdministrador.save(administrador);
			
		}
	
	
	public List<Administrador> obtenerAdministradores() {
		return this.repositoryAdministrador.findAll();
	}
		
}
