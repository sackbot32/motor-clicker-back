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
import com.inserta.entities.Usuario;
import com.inserta.repos.PremioRepo;
import com.inserta.services.PremioService;
import com.inserta.tss.UsuarioNotFoundException;





/* para que puedas ustilizar los metodos post put, delete y get  en angular
 * Tienes que poner @RestController en lugar de @Controller
 *  
 *  */

@CrossOrigin
@RestController
@RequestMapping("/premiosCrud")
public class PremioController {
	@Autowired
	PremioService premioService;
	
	@Autowired
	PremioRepo premioRepo;
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		
		
		model.addAttribute("lista", premioService.getPremios());
		
		
		return "premioListado";
	}
	
	@RequestMapping("/eliminar/{id_premio}")
	public String delete(Model model, @PathVariable("id_premio") Integer id) {
		
		premioService.eliminarPremio(id);
		
		return "redirect:/premiosCrud/lista";
	}
	
	@RequestMapping("/irAEditar/{id_premio}")
	public String IrEditar(Model model,@PathVariable("id_premio") Integer id) {
		
		
		model.addAttribute("premio", premioService.obtenerUnPremio(id));
		
		
		return "premiosCrudEdit";
	}
	
	
	@RequestMapping("/editar")
	public String editar(
			@RequestParam("nombre") String nombre,
			@RequestParam("precio") Integer precio,
			@RequestParam("produce") Integer produce,
			@RequestParam("foto") String foto,
			@RequestParam("id") Integer id) {
		
		premioService.editarPremio(nombre, precio, produce, foto, id);
		return "redirect:/premiosCrud/lista";
	}
	
	
	
	
	//metodo para obtener desde angular el listado de todos
		@GetMapping("/premios")
		public List<Premio> all() {
			return premioRepo.findAll();
		}
		
		//metodo para obtener desde angular uno solo de la lista
		@GetMapping("/premios/{id}")
		Premio one( @PathVariable int id ){
			return	premioRepo
						.findById(id)
						.orElseThrow(() -> new UsuarioNotFoundException(id));
		}
		
	//metodo post para introducir desde angular
		@PostMapping("/premios")
		public Premio newPremio( @RequestBody Premio premio ) {
			return premioRepo.save(premio);
		}
		
		
		
		//metodo para actualizar en angular
		@PutMapping("/premios/{id}")
		public Premio replacePremio(
			  @RequestBody Premio nuevopremio, 
			  @PathVariable Integer id
		  ) {
		    return premioRepo.findById(id).map(premio->{
		    	premio.setNombre(nuevopremio.getNombre());
		    	premio.setPrecio(nuevopremio.getPrecio());
		    	premio.setFoto(nuevopremio.getFoto());
		    	premio.setProduce(nuevopremio.getProduce());
		    
		    	
		    	  
		        return premioRepo.save(premio);
		        }).orElseThrow(() -> new UsuarioNotFoundException(id));
		  }
		
		
		//método para borrar en angular
		@DeleteMapping("/premios/{id}")
		void deletePremio( @PathVariable Integer id ) {
			premioRepo.deleteById(id);
		}					
						
}
