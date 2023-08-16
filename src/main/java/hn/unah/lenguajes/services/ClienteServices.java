package hn.unah.lenguajes.services;

import java.util.List;

import hn.unah.lenguajes.dto.DatosCliente;
import hn.unah.lenguajes.models.Cliente;

public interface ClienteServices {
	
	//CRUD
	public List<Cliente> obtenerClientes();
	public Cliente buscarClientePorCorreo(String correo);
	public Cliente crearCliente(Cliente cliente);
	public Cliente eliminarCliente(String correo);
	public Cliente actualizarCliente(String correo, Cliente cliente);
	
	public boolean validarCiente(DatosCliente datos);
	
}
