package hn.unah.lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.dto.NuevoConductor;
import hn.unah.lenguajes.models.Conductor;
import hn.unah.lenguajes.services.impl.ConductoresServicesImpl;

@RestController
@RequestMapping ("/conductores")
public class ConductoresController {
	@Autowired
	private ConductoresServicesImpl impl;
	
	@GetMapping("/obtener")
	public Iterable<Conductor> obtenerConductores(){
		Iterable<Conductor> listaConductores=impl.obtenerConductoreses();
		return listaConductores;
	}
	
	@PostMapping("/contratar")
	public boolean contratarConductor(@RequestBody NuevoConductor info) {
		return impl.contratarConductor(info);
	}
	
	@PostMapping("/actualizar/{id}")
	public Conductor actualizarConductores(@RequestBody Conductor conductor, @PathVariable int id) {
		return impl.actualizarConductores(id, conductor);
	}
	
	@GetMapping("/eliminar/{id}")
	public Conductor eliminarConductores(@PathVariable int id) {
		return impl.eliminarConductores(id);
	}
	
	@GetMapping("/obtener/{id}")
	public Conductor obtenerPorId(@PathVariable int id) {
		return impl.buscarConductoresPorId(id);
	}
	
}
