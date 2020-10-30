package com.bancadigital.app.service;

import java.util.List;

import com.bancadigital.app.model.Cliente_Usuario;
import com.bancadigital.app.model.Clientes;


public interface ClienteService {
   
	
	//public List<Clientes> findAll();
	
	public Clientes findById(long id);
	
	public Clientes save(Clientes cliente);
	
	public int deleteById(int id);
	
	public Clientes findByIdentificacionAndNombre(int identificacion,String nombre);
	
	public Cliente_Usuario findByIdentificacionAndPassword(int identificacion,String password);
	
	public List <Cliente_Usuario> findAll();
}
