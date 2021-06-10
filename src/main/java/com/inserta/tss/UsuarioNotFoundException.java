package com.inserta.tss;

public class UsuarioNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(Integer id) {
	    super("Could not find employee " + id);
	  }
}
