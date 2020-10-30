package com.bancadigital.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bancadigital.app.model.Clientes;
import com.bancadigital.app.model.Clientes_Credenciales;

@Repository
public class ClienteDAOImpl implements ClienteDAO{
	
	@Autowired
	private EntityManager entityManager;
	
    /*@Autowired
    public ClienteDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;

    }*/
    
    //get all the transactions from the database
	public List<Clientes> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Clientes> theQuery = currentSession.createQuery("from Clientes", Clientes.class); // from Clientes = Clientes es el nombre de la clase de mi entity (el nombre de la clase del  model) 
		System.out.print("el query"+theQuery);
		List<Clientes> clientes = theQuery.getResultList();
		
		return clientes;

	}
	
	   //return the transaction by giving id as input    
	public Clientes findById(long id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Clientes cliente = currentSession.get(Clientes.class, id);
		
		return cliente;
	}

    //add the transaction to the database
	@Transactional
	public 	Clientes save(Clientes cliente) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(cliente);
		return cliente;
		
	}
	
	
    //delete the transaction from the database using transaction id    
	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Clientes> theQuery = currentSession.createQuery("delete from Cliente where id=:idCliente");
		
		theQuery.setParameter("idCliente", id);
		theQuery.executeUpdate();
		
	}

	public Clientes findByIdentificacion(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	public Clientes_Credenciales findByUsuarioAndPassword(int identificacion, int password) {
		Session currentSession = entityManager.unwrap(Session.class);

		Clientes_Credenciales cliente = currentSession.get(Clientes_Credenciales.class, identificacion);
		
		return cliente;
	}


}
