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

import com.inserta.entities.Premio;
import com.inserta.entities.UsuarioPremio;
import com.inserta.repos.UsuariopremioRepo;
import com.inserta.services.UsuariopremioService;
import com.inserta.tss.UsuarioNotFoundException;

/**para que puedas ustilizar los metodos post put, delete y get  en angular
* Tienes que poner @RestController en lugar de @Controller
*/

@CrossOrigin
@RestController
@RequestMapping("/usuariospremiosCrud")
public class usuariopremioController {
	@Autowired
	UsuariopremioService usuarioPremioService;
	
	@Autowired
	UsuariopremioRepo usuarioPremioRepo;
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		
		
		model.addAttribute("lista", usuarioPremioService.getPremios());
		
		
		return "usuariopremioListado";
	}
	
	@RequestMapping("/eliminar/{id_usuariopremio}")
	public String delete(Model model, @PathVariable("id_usuariopremio") Integer id) {
		
		usuarioPremioService.eliminarPremio(id);
		
		return "redirect:/usuariospremiosCrud/lista";
	}
	
	@RequestMapping("/irAEditar/{id_usuariopremio}")
	public String IrEditar(Model model,@PathVariable("id_usuariopremio") Integer id) {
		
		
		model.addAttribute("usuariopremio", usuarioPremioService.obtenerUnPremio(id));
		
		
		return "usuariospremiosCrudEdit";
	}
	
	
	@RequestMapping("/editar")
	public String editar(
			@RequestParam("cantidad") Integer cantidad,
			@RequestParam("id") Integer id) {
		
		usuarioPremioService.editarUsuarioPremio(cantidad, id);
		return "redirect:/usuariospremiosCrud/lista";
	}
	
	//metodo para obtener desde angular el listado de todos
			@GetMapping("/usuariospremios")
			public List<UsuarioPremio> all() {
				return usuarioPremioRepo.findAll();
			}
			
			//metodo para obtener desde angular uno solo de la lista
			@GetMapping("/usuariospremios/{id}")
		public UsuarioPremio one( @PathVariable int id ){
				return	usuarioPremioRepo
							.findById(id)
							.orElseThrow(() -> new UsuarioNotFoundException(id));
			}
			
		//metodo post para introducir desde angular
			@PostMapping("/usuariospremios")
			public UsuarioPremio newUsuarioPremio( @RequestBody UsuarioPremio usuarioPremio ) {
				return usuarioPremioRepo.save(usuarioPremio);
			}
			
			
			
			//metodo para actualizar en angular
			@PutMapping("/usuariospremios/{id}")
			public UsuarioPremio replaceUsuarioPremio(
				  @RequestBody UsuarioPremio nuevoUsuarioPremio, 
				  @PathVariable Integer id
			  ) {
			    return usuarioPremioRepo.findById(id).map(usuarioPremio->{
			    	usuarioPremio.setCantidad(nuevoUsuarioPremio.getCantidad());
			    
			    	
			    	  
			        return usuarioPremioRepo.save(usuarioPremio);
			        }).orElseThrow(() -> new UsuarioNotFoundException(id));
			  }
			
			
			//método para borrar en angular
			@DeleteMapping("/usuariospremios/{id}")
			void deletePremio( @PathVariable Integer id ) {
				usuarioPremioRepo.deleteById(id);
			}					

}

