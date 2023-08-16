/*package hn.unah.lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.models.OrdenServicio;
import hn.unah.lenguajes.services.impl.OrdenServicioServicesImpl;

@RestController
@RequestMapping ("/ordenes")
public class OrdenServicioController {
	
	@Autowired
	private OrdenServicioServicesImpl impl;
	
	@GetMapping("/obtener")
	public Iterable<OrdenServicio> obtenerOrden_Servicio(){
		Iterable<OrdenServicio> listaordenes=impl.obtenerOrden_Servicioes();
		return listaordenes;
	}
	
	@PostMapping("/crear")
	public OrdenServicio crearOrden_Servicio(@RequestBody OrdenServicio automovil) {
		return impl.crearOrden_Servicio(automovil);
	}
	
	@PostMapping("/actualizar/{id}")
	public OrdenServicio actualizarOrden_Servicio(@RequestBody OrdenServicio automovil, @PathVariable int id) {
		return impl.actualizarOrden_Servicio(id, automovil);
	}
	
	@GetMapping("/eliminar/{id}")
	public OrdenServicio eliminarOrden_Servicio(@PathVariable int id) {
		return impl.eliminarOrden_Servicio(id);
	}
	
	@GetMapping("/obtener/{id}")
	public OrdenServicio obtenerPorId(@PathVariable int id) {
		return impl.buscarOrdenServicioPorId(id);
	}
	
*/
