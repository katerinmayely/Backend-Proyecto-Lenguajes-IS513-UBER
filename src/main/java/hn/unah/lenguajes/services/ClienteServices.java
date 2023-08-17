package hn.unah.lenguajes.services;

import java.util.List;

import hn.unah.lenguajes.dto.DatosCliente;
import hn.unah.lenguajes.dto.NuevoUsuario;
import hn.unah.lenguajes.models.Cliente;
import hn.unah.lenguajes.models.OrdenServicio;

public interface ClienteServices {
	
	public List<Cliente> obtenerClientes();
	public Cliente buscarClientePorCorreo(String correo);
	public Cliente eliminarCliente(String correo);
	public Cliente actualizarCliente(String correo, Cliente cliente);
	
	public boolean validarCiente(DatosCliente datos);
	public boolean crearCliente(NuevoUsuario datos);
	
	public List<OrdenServicio> obtenerOrdenes(String id);
	
}
