package hn.unah.lenguajes.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.models.Cliente;
import hn.unah.lenguajes.repositories.ClientesRepository;
import hn.unah.lenguajes.services.ClienteServices;

@Service
public class ClienteServicesImpl implements ClienteServices{
	
	@Autowired
	private ClientesRepository repo;
	
	@Override
	public List<Cliente> obtenerClientes() {
		return (List<Cliente>) repo.findAll();
		
	}

	@Override
	public Cliente buscarClientePorId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Cliente crearCliente(Cliente Cliente) {
		// TODO Auto-generated method stub
		repo.save(Cliente);
		return Cliente;
	}

	@Override
	public Cliente eliminarCliente(int id) {
		repo.deleteById(id);
		return null;
	}

	@Override
	public Cliente actualizarCliente(int id, Cliente cliente) {
		Cliente nvoCliente=repo.findById(id).get();
		nvoCliente.setTarjetaVinculada(cliente.getTarjetaVinculada());
		nvoCliente.setCoordenadascliente(cliente.getCoordenadascliente());
		nvoCliente.setTarjetaVinculada(cliente.getTarjetaVinculada());
		repo.deleteById(id);
		repo.save(nvoCliente);
		return cliente;
	}
	
}
