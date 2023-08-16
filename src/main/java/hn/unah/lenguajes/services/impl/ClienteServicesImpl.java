package hn.unah.lenguajes.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.dto.DatosCliente;
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
	public Cliente buscarClientePorCorreo(String correo) {
		return repo.findById(correo).orElse(null);
	}

	@Override
	public Cliente crearCliente(Cliente Cliente) {
		// TODO Auto-generated method stub
		repo.save(Cliente);
		return Cliente;
	}

	@Override
	public Cliente eliminarCliente(String correo) {
		repo.deleteById(correo);
		return null;
	}

	@Override
	public Cliente actualizarCliente(String correo, Cliente cliente) {
		Cliente nvoCliente=repo.findById(correo).get();
		nvoCliente.setTarjetaVinculada(cliente.getTarjetaVinculada());
		nvoCliente.setUbicacion(cliente.getUbicacion());
		nvoCliente.setTarjetaVinculada(cliente.getTarjetaVinculada());
		repo.deleteById(correo);
		repo.save(nvoCliente);
		return cliente;
	}

	@Override
	public boolean validarCiente(DatosCliente datos) {
		
		if(repo.existsById(datos.getCorreo())) {
			Cliente cliente = repo.findById(datos.getCorreo()).orElse(null);
			
			if(cliente.getContrasenia().equals(datos.getContrasenia())) {
				return true;
			}
			
			return false;
		}
		return false;
	}
	
}
