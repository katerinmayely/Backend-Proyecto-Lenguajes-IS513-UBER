package hn.unah.lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.dto.ViajeServicio;
import hn.unah.lenguajes.models.ViajeOrdenServicio;
import hn.unah.lenguajes.services.impl.ViajeOrdenServicioImpl;

@RestController
@RequestMapping("/viajes")
public class Viaje_Orden_Servicio_Controller {
	
	@Autowired
	private ViajeOrdenServicioImpl impl;
	
	@GetMapping("/obtener")
	public Iterable<ViajeOrdenServicio> obtenerViaje_Orden_Servicio(){
		Iterable<ViajeOrdenServicio> listaViaje=impl.obtenerViajeOrdenServicio();
		return listaViaje;
	}
	
	@PostMapping("/crear")
	public ViajeOrdenServicio crearViaje_Orden_Servicio(@RequestBody ViajeServicio viaje) {
		return impl.crearViajeOrdenServicio(viaje);
	}
	
	@PostMapping("/actualizar/{id}")
	public ViajeOrdenServicio actualizarViaje_Orden_Servicio(@RequestBody ViajeOrdenServicio viaje, @PathVariable int id) {
		return impl.actualizarViaje_Orden_Servicio(id, viaje);
	}
	
	@GetMapping("/eliminar/{id}")
	public ViajeOrdenServicio eliminarViaje_Orden_Servicio(@PathVariable int id) {
		return impl.eliminarViaje_Orden_Servicio(id);
	}
	
	@GetMapping("/obtener/{id}")
	public ViajeOrdenServicio obtenerPorId(@PathVariable int id) {
		return impl.buscarViajeOrdenServicioPorId(id);
	}
	
}
