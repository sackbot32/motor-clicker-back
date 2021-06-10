package com.inserta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import com.inserta.entities.Usuario;
import com.inserta.repos.UsuarioRepo;
import com.inserta.services.UsuarioService;
import com.inserta.tss.UsuarioNotFoundException;

/*para que puedas ustilizar los metodos post put, delete y get  en angular
 * Tienes que poner @RestController en lugar de @Controller
 *  
 *  */
@CrossOrigin
@RestController
@RequestMapping("/usuariosCrud")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioRepo usuarioRepo;
	
	
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		
		
		model.addAttribute("lista",usuarioService.getUsuarios());
		
		
		return "usuarioListado";
	}
	
	@RequestMapping("/eliminar/{id_usuario}")
	public String delete(Model model, @PathVariable("id_usuario") Integer id) {
		
		usuarioService.eliminarUsuario(id);
		
		return "redirect:/usuariosCrud/lista";
	}
	
	
	
	@RequestMapping("/irAEditar/{id_usuario}")
	public String IrEditar(Model model,@PathVariable("id_usuario") Integer id) {
		
		
		model.addAttribute("usuario", usuarioService.obtenerUnUsuario(id));
		
		
		return "usuariosCrudEdit";
	}
	
	
	@RequestMapping("/editar")
	public String editar( @RequestParam("nick") String nick,
			@RequestParam("nombre") String nombre,
			@RequestParam("email") String email,
			@RequestParam("clave") String clave,
			@RequestParam("puntuacion") Integer puntuacion,
			@RequestParam("id") Integer id) {
		
		usuarioService.editarUsuario(nombre, nick, email, clave, puntuacion, id);
		
		return "redirect:/usuariosCrud/lista";
	}
	
	//metodo para obtener desde angular todos los usuarios
	@GetMapping("/usuarios")
	public List<Usuario> all() {
		return usuarioRepo.findAll();
	}
	
	//metodo para obtener desde angular solo un usuario por su id
	@GetMapping("/usuarios/{id}")
	Usuario one( @PathVariable int id ){
		
		return	usuarioRepo
					.findById(id)
					.orElseThrow(() -> new UsuarioNotFoundException(id));
	}
	
	
	
	
	
	
	//metodo post para introducir desde angular
	@PostMapping("/usuarios")
	public Usuario newUser(@RequestBody Usuario usuario) {
		System.out.println("LLEGA");
		return usuarioRepo.save(usuario);
	}
	
	
	
	//metodo para actualizar en angular
	@PutMapping("/usuarios/{id}")
	public Usuario replaceUser(
		  @RequestBody Usuario nuevoUsuario, 
		  @PathVariable Integer id
	  ) {
	    return usuarioRepo.findById(id).map(usuario -> {
	    	  usuario.setNombre(nuevoUsuario.getNombre());
	    	  usuario.setNick(nuevoUsuario.getNick());
	    	  usuario.setEmail(nuevoUsuario.getEmail());
	    	  usuario.setClave(nuevoUsuario.getClave());
	    	  usuario.setPuntuacion(nuevoUsuario.getPuntuacion());
	    	  
	        return usuarioRepo.save(usuario);
	      }).orElseThrow(() -> new UsuarioNotFoundException(id));
	  }
	
	//método para borrar en angular
	@DeleteMapping("/usuarios/{id}")
	void deleteUser( @PathVariable Integer id ) {
		usuarioRepo.deleteById(id);
	}
}
