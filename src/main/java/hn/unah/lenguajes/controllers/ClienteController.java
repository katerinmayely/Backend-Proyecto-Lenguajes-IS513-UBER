package hn.unah.lenguajes.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.dto.DatosCliente;
import hn.unah.lenguajes.dto.NuevoUsuario;
import hn.unah.lenguajes.models.Cliente;
import hn.unah.lenguajes.models.OrdenServicio;
import hn.unah.lenguajes.models.ViajeOrdenServicio;
import hn.unah.lenguajes.services.impl.ClienteServicesImpl;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteServicesImpl impl;
	
	@PostMapping("/validar")
	public boolean validarCliente(@RequestBody DatosCliente datos) {
		return impl.validarCiente(datos);
	}
	
	
	@GetMapping("/obtener")
	public Iterable<Cliente> obtenerCliente(){
		Iterable<Cliente> listaClientes=impl.obtenerClientes();
		return listaClientes;
	}
	
	@PostMapping("/crear")
	public boolean crearCliente(@RequestBody NuevoUsuario cliente) {
		return impl.crearCliente(cliente);
	}
	
	@GetMapping("/obtenerOrdenes/{correo}")
	public List<OrdenServicio> obtenerOrdenes(@PathVariable String correo){
		
		
	   
	     return impl.obtenerOrdenes(correo);
	}
	
	@PostMapping("/actualizar/{id}")
	public Cliente actualizarCliente(@RequestBody Cliente cliente, @PathVariable String correo) {
		return impl.actualizarCliente(correo, cliente);
	}
	
	@GetMapping("/eliminar/{id}")
	public Cliente eliminarCliente(@PathVariable String correo) {
		return impl.eliminarCliente(correo);
	}
	
	@GetMapping("/obtener/{correo}")
	public Cliente obtenerPorId(@PathVariable String correo) {
		return impl.buscarClientePorCorreo(correo);
	}
	
}
