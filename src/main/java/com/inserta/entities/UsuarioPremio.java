package com.inserta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuariospremios")
public class UsuarioPremio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuariopremio;
	private int idusuario;
	private int idpremio;
	private int cantidad;
	
	
	UsuarioPremio(){}


	public UsuarioPremio(int idusuariopremio, int idusuario, int idpremio, int cantidad) {
		super();
		this.idusuariopremio = idusuariopremio;
		this.idusuario = idusuario;
		this.idpremio = idpremio;
		this.cantidad = cantidad;
	}


	public int getIdusuariopremio() {
		return idusuariopremio;
	}


	public void setIdusuariopremio(int idusuariopremio) {
		this.idusuariopremio = idusuariopremio;
	}


	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	public int getIdpremio() {
		return idpremio;
	}


	public void setIdpremio(int idpremio) {
		this.idpremio = idpremio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "UsuarioPremio [idusuariopremio=" + idusuariopremio + ", idusuario=" + idusuario + ", idpremio="
				+ idpremio + ", cantidad=" + cantidad + "]";
	}
	
	
}
