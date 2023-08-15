package hn.unah.lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hn.unah.lenguajes.dto.AutoConductor;
import hn.unah.lenguajes.models.Automovil;
import hn.unah.lenguajes.services.impl.AutomovilServicesImpl;

@RestController
@RequestMapping ("/automoviles")
public class AutomovilController {

	@Autowired
	private AutomovilServicesImpl impl;
	
	@GetMapping("/obtener")
	public Iterable<Automovil> obtenerAutomovil(){
		Iterable<Automovil> listaAutos=impl.obtenerAutomoviles();
		return listaAutos;
	}
	
	@PostMapping("/crear")
	public Automovil crearAutomovil(@RequestBody Automovil automovil) {
		return impl.crearAutomovil(automovil);
	}
	
	@PostMapping("/actualizar/{id}")
	public Automovil actualizarAutomovil(@RequestBody Automovil automovil, @PathVariable String id) {
		return impl.actualizarAutomovil(id, automovil);
	}
	
	@GetMapping("/eliminar/{id}")
	public Automovil eliminarAutomovil(@PathVariable String id) {
		return impl.eliminarAutomovil(id);
	}
	
	@GetMapping("/obtener/{id}")
	public Automovil obtenerPorId(@PathVariable String id) {
		return impl.buscarAutomovilPorId(id);
	}
	
	@GetMapping("/asignarConductor")
	public Automovil asignarConductor(@RequestBody AutoConductor autoConductor) {
		
		return impl.asignarConductorAutomovil(autoConductor);
	}
	
}
