package hn.unah.lenguajes.services;

import java.util.List;
import hn.unah.lenguajes.models.Cliente;

public interface ClienteServices {
	public List<Cliente> obtenerClientes();
	public Cliente buscarClientePorId(int id);
	public Cliente crearCliente(Cliente cliente);
	public Cliente eliminarCliente(int id);
	public Cliente actualizarCliente(int id, Cliente cliente);
}
