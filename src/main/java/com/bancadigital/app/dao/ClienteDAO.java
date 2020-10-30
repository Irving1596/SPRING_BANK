package com.bancadigital.app.dao;

import java.util.List;

import com.bancadigital.app.model.Clientes;
import com.bancadigital.app.model.Clientes_Credenciales;



public interface ClienteDAO {
	
	
	public List<Clientes> findAll();
	
	public Clientes findById(long id);
	
	public Clientes findByIdentificacion(String mail);
	
	public Clientes save(Clientes cliente);
	
	public void deleteById(int id);

	public Clientes_Credenciales findByUsuarioAndPassword(int identificacion,int password);

}
