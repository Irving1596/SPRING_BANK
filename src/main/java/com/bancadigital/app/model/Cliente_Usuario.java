package com.bancadigital.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
@SecondaryTable(name="cliente_credencial",pkJoinColumns=@PrimaryKeyJoinColumn(name="id_cliente",referencedColumnName="id"))
public class Cliente_Usuario {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;	
	
@Column(name="celular")
private int celular;

@Column(name="correo")
private String correo; 

@Column(name="identificacion")
private int identificacion;

/*@Column(name="id_cliente",table="cliente_credencial")
private Long id_cliente;
Solo tener el id principal esto nooo
 */

@Column(name="usuario",table="cliente_credencial")
private String usuario; 

@Column(name="password",table="cliente_credencial")
private String password; 


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}


public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getCelular() {
	return celular;
}

public void setCelular(int celular) {
	this.celular = celular;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public int getIdentificacion() {
	return identificacion;
}

public void setIdentificacion(int identificacion) {
	this.identificacion = identificacion;
} 





}
