package com.bancadigital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancadigital.app.model.Cliente_Usuario;
import com.bancadigital.app.model.Clientes;

@Repository
public interface clienteUsuarioRepository extends JpaRepository <Cliente_Usuario,Long> {
	
	public Cliente_Usuario findByIdentificacionAndPassword(int identificacion,String password);
	public List <Cliente_Usuario> findAll();

}
