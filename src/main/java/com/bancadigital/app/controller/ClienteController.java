package com.bancadigital.app.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bancadigital.app.model.Cliente_Usuario;
import com.bancadigital.app.model.Clientes;
import com.bancadigital.app.repository.clienteRepository;
import com.bancadigital.app.service.ClienteService;

//Cors me permite restringir las peticiones dependiendo del dominio que solicita la peticion
@CrossOrigin(origins={"https://localhost:4200"})

//Indiciamos que es un controlador rest
@RestController
@RequestMapping({""})//esta sera la raiz de la url, es decir http://127.0.0.1:8080/
public class ClienteController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	//Inyectamos el servicio para poder hacer uso de el
	@Autowired 
	private ClienteService clienteService;

	@GetMapping("/clientes")
	public List<Cliente_Usuario> findAll(){ 
		//retornará todos los usuarios
		System.out.print("en controller"+clienteService);
		return clienteService.findAll();
	}

	
	/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
	http://127.0.0.1:8080/api/users/1*/
	@GetMapping("/cliente_datos")
	public Clientes getCliente_Datos(@RequestParam(value="identificacion", required=true) int identificacion,@RequestParam(value="nombre", required=true) String nombre ){
		Clientes cliente = clienteService.findByIdentificacionAndNombre(identificacion, nombre);
		
		if(cliente == null) {
			throw new RuntimeException("User id not found -"+identificacion);
		}
		//retornará al cliente con id pasado en la url
		return cliente;
	}
	
	/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
	http://127.0.0.1:8080/bancadigital/recovery_user  */
	@GetMapping("/recovery_user")
	public Cliente_Usuario getRecovery_User(@RequestParam(value="identificacion", required=true) int identificacion,@RequestParam(value="password", required=true) String password ){
		Cliente_Usuario cliente_user = clienteService.findByIdentificacionAndPassword(identificacion, password);
		if(cliente_user == null) {
			throw new RuntimeException("User not found -"+identificacion);
		} 
		//retornará al cliente con id pasado en la url
		return cliente_user;
	}
	
	
	/*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
	http://127.0.0.1:8080/api/users/  */
	@PostMapping("/create_code")
	public void addUser(@RequestBody Clientes cliente) {

		
		
		  LOGGER.info("This is an info message"+cliente);
		  LOGGER.info("celular"+cliente.getCelular());
		  LOGGER.info("correo"+cliente.getCorreo());
		
	}
	/*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
	http://127.0.0.1:8080/api/users/  */
	@PutMapping("/cliente")
	public Clientes updateUser(@RequestBody Clientes cliente) {
		
		clienteService.save(cliente);
		
		//este metodo actualizará al usuario enviado
		
		return cliente;
	}
	
	/*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
	http://127.0.0.1:8080/api/users/1  */
	@DeleteMapping("users/{clienteId}")
	public String deteteUser(@PathVariable int clienteId) {
		
		Clientes cliente = clienteService.findById(clienteId);
		
		if(cliente == null) {
			throw new RuntimeException("User id not found -"+clienteId);
		}
		
		clienteService.deleteById(clienteId);
		
		//Esto método, recibira el id de un usuario por URL y se borrará de la bd.
		return "Deleted user id - "+clienteId;
	}
}
