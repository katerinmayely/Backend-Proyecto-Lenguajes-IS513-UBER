package hn.unah.lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.models.Cliente;
import hn.unah.lenguajes.services.impl.ClienteServicesImpl;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteServicesImpl impl;
	
	@GetMapping("/obtener")
	public Iterable<Cliente> obtenerCliente(){
		Iterable<Cliente> listaClientes=impl.obtenerClientes();
		return listaClientes;
	}
	
	@PostMapping("/crear")
	public Cliente crearCliente(@RequestBody Cliente automovil) {
		return impl.crearCliente(automovil);
	}
	
	@PostMapping("/actualizar/{id}")
	public Cliente actualizarCliente(@RequestBody Cliente automovil, @PathVariable int id) {
		return impl.actualizarCliente(id, automovil);
	}
	
	@GetMapping("/eliminar/{id}")
	public Cliente eliminarCliente(@PathVariable int id) {
		return impl.eliminarCliente(id);
	}
	
	@GetMapping("/obtener/{id}")
	public Cliente obtenerPorId(@PathVariable int id) {
		return impl.buscarClientePorId(id);
	}
	
}
