package hn.unah.lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hn.unah.lenguajes.models.Direccion;
import hn.unah.lenguajes.services.impl.DireccionesServicesImpl;

@RestController
@RequestMapping ("/direcciones")
public class DireccionesController {
	
	@Autowired
	private DireccionesServicesImpl impl;
	
	@GetMapping("/obtener")
	public Iterable<Direccion> obtenerDirecciones(){
		Iterable<Direccion> listaDirecciones=impl.obtenerDirecciones();
		return listaDirecciones;
	}
	
	@PostMapping("/crear")
	public Direccion crearDirecciones(@RequestBody Direccion automovil) {
		return impl.crearDirecciones(automovil);
	}
	
	@PostMapping("/actualizar/{id}")
	public Direccion actualizarDirecciones(@RequestBody Direccion automovil, @PathVariable int id) {
		return impl.actualizarDirecciones(id, automovil);
	}
	
	@GetMapping("/eliminar/{id}")
	public Direccion eliminarDirecciones(@PathVariable int id) {
		return impl.eliminarDirecciones(id);
	}
	
	@GetMapping("/obtener/{id}")
	public Direccion obtenerPorId(@PathVariable int id) {
		return impl.buscarDireccionesPorId(id);
	}
	
}
