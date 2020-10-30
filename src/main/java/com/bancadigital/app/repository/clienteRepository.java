package com.bancadigital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bancadigital.app.model.Clientes;

@Repository
public interface clienteRepository extends JpaRepository<Clientes,Long> {
	
	//@Query("select c from Cliente c where u.emailAddress = ?1")
	public Clientes findByIdentificacionAndNombre(int identificacion,String nombre);
}
