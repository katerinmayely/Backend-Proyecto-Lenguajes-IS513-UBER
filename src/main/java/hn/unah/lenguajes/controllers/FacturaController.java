package hn.unah.lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.dto.InfoFactura;
import hn.unah.lenguajes.models.Factura;
import hn.unah.lenguajes.services.impl.FacturaServicesImpl;

@RestController
@RequestMapping ("/facturas")
public class FacturaController {
	
	@Autowired
	private FacturaServicesImpl impl;
	@GetMapping("/obtener")
	public Iterable<Factura> obtenerFactura(){
		Iterable<Factura> listaFactura=impl.obtenerFacturaes();
		return listaFactura;
	}
	
	@PostMapping("/crear")
	public Factura crearFactura(@RequestBody InfoFactura infoFactura) {
		return impl.crearFactura(infoFactura);
	}
	
	@PostMapping("/actualizar/{id}")
	public Factura actualizarFactura(@RequestBody Factura automovil, @PathVariable int id) {
		return impl.actualizarFactura(id, automovil);
	}
	
	@GetMapping("/eliminar/{id}")
	public Factura eliminarFactura(@PathVariable int id) {
		return impl.eliminarFactura(id);
	}
	
	@GetMapping("/obtener/{id}")
	public Factura obtenerPorId(@PathVariable int id) {
		return impl.buscarFacturaPorId(id);
	}
	
}
