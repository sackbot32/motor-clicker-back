package com.inserta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuario;
	private String nombre;
	private String nick;
	private String email;
	private String clave;
	private int puntuacion;
	
	public Usuario() {}

	public Usuario(int idusuario, String nombre, String nick, String email, String clave, int puntuacion) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.nick = nick;
		this.email = email;
		this.clave = clave;
		this.puntuacion = puntuacion;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre=" + nombre + ", nick=" + nick + ", email=" + email
				+ ", clave=" + clave + ", puntuacion=" + puntuacion + "]";
	}

	
	

}
