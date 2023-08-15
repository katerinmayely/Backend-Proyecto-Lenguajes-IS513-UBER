package hn.unah.lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hn.unah.lenguajes.dto.ClientePersona;
import hn.unah.lenguajes.dto.ConductorPersona;
import hn.unah.lenguajes.models.Persona;
import hn.unah.lenguajes.services.impl.PersonasServicesImpl;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	private PersonasServicesImpl impl;
	@GetMapping("/obtener")
	public Iterable<Persona> obtenerPersona(){
		Iterable<Persona> listaPersonas=impl.obtenerPersonaes();
		return listaPersonas;
	}
	
	@PostMapping("/crear")
	public Persona crearPersona(@RequestBody Persona persona) {
		return impl.crearPersona(persona);
	}
	
	@PostMapping("/actualizar/{id}")
	public Persona actualizarPersona(@RequestBody Persona persona, @PathVariable String id) {
		return impl.actualizarPersona(id, persona);
	}
	
	@GetMapping("/eliminar/{id}")
	public Persona eliminarPersona(@PathVariable String id) {
		return impl.eliminarPersona(id);
	}
	
	@GetMapping("/obtener/{id}")
	public Persona obtenerPorId(@PathVariable String id) {
		return impl.buscarPersonaPorId(id);
	}
	
	@PostMapping("/hacerConductor")
	public Persona hacerConductor(@RequestBody ConductorPersona conductorPersona) {
		System.out.println(conductorPersona.toString());
	
		return impl.hacerConductor(conductorPersona);
		
	}
	
	@PostMapping("/hacerCliente")
	public Persona hacerCliente(@RequestBody ClientePersona clientePersona) {
		
		return impl.hacerCliente(clientePersona);
		
	}
	
}
