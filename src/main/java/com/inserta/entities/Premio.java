package com.inserta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="premios")
public class Premio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpremio;
	private String nombre;
	private int precio;
	private int produce;
	private String foto;
	
	public Premio() {}

	public Premio(int idpremio, String nombre, int precio, int produce, String foto) {
		super();
		this.idpremio = idpremio;
		this.nombre = nombre;
		this.precio = precio;
		this.produce = produce;
		this.foto = foto;
	}

	public int getIdpremio() {
		return idpremio;
	}

	public void setIdpremio(int idpremio) {
		this.idpremio = idpremio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getProduce() {
		return produce;
	}

	public void setProduce(int produce) {
		this.produce = produce;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Premio [idpremio=" + idpremio + ", nombre=" + nombre + ", precio=" + precio + ", produce=" + produce
				+ ", foto=" + foto + "]";
	}
	
	

}
