package com.bancadigital.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bancadigital.app.dao.ClienteDAO;
import com.bancadigital.app.model.Cliente_Usuario;
import com.bancadigital.app.model.Clientes;
import com.bancadigital.app.repository.clienteRepository;
import com.bancadigital.app.repository.clienteUsuarioRepository;


@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private clienteRepository clienteRepo;
	
	@Autowired
	private clienteUsuarioRepository clienteUsuRepo;
    /*@Autowired
    public ClienteServiceImpl(@Qualifier("ClienteDAOImpl") ClienteDAO theclienteDao){
        clienteDAO = theclienteDao;
    }*/
	//se puede omitir 
    //@Transactional(readOnly=true)
	public List<Cliente_Usuario> findAll() {
		List<Cliente_Usuario> listClientes= clienteUsuRepo.findAll();
		return listClientes;
	}
	

	public Clientes findById(long id) {
		Clientes cliente = clienteDAO.findById(id);
		return cliente;
	}

	public Clientes save(Clientes cliente) {
		clienteDAO.save(cliente);
		return cliente;
	}

	public int deleteById(int id) {
		clienteDAO.deleteById(id);
		return id;
	}


	public Clientes findByIdentificacionAndNombre(int identificacion, String nombre) {
		// TODO Auto-generated method stub
		return clienteRepo.findByIdentificacionAndNombre(identificacion, nombre);
	}


	public Cliente_Usuario findByIdentificacionAndPassword(int identificacion, String password) {
		// TODO Auto-generated method stub
		return clienteUsuRepo.findByIdentificacionAndPassword(identificacion, password);
	}

}
