package hn.unah.lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.models.Calificacion;
import hn.unah.lenguajes.services.impl.CalificacionServicesImpl;

@RestController
@RequestMapping ("/calificaciones")
public class CalificacionController {
	@Autowired
	private CalificacionServicesImpl impl;
	
	@GetMapping("/obtener")
	public Iterable<Calificacion> obtenerCalificacion(){
		Iterable<Calificacion> listaCalificacion=impl.obtenerCalificaciones();
		return listaCalificacion;
	}
	
	@PostMapping("/crear")
	public Calificacion crearCalificacion(@RequestBody Calificacion calificacion) {
		return impl.crearCalificacion(calificacion);
	}
	
	@PostMapping("/actualizar/{id}")
	public Calificacion actualizarCalificacion(@RequestBody Calificacion calificacion, @PathVariable int id) {
		return impl.actualizarCalificacion(id, calificacion);
	}
	
	@GetMapping("/eliminar/{id}")
	public Calificacion eliminarCalificacion(@PathVariable int id) {
		return impl.eliminarCalificacion(id);
	}
	
	@GetMapping("/obtener/{id}")
	public Calificacion obtenerPorId(@PathVariable int id) {
		return impl.obtenerCalificacionPorId(id);
	}
	
}
