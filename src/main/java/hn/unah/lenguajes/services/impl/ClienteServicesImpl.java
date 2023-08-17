package hn.unah.lenguajes.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.dto.DatosCliente;
import hn.unah.lenguajes.dto.NuevoUsuario;
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
	public boolean crearCliente(NuevoUsuario datos) {
		
		if(datos.getContrasenia().equals(datos.getContraseniaValidacion())){
			Cliente nvoCliente = new Cliente(datos.getCorreo(), null, datos.getNombre(), datos.getApellido(), datos.getContrasenia(), datos.getCelular(), null, null, null);
			repo.save(nvoCliente);
			return true;
		}
		
		return false;
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
		nvoCliente.setUbicacionCliente(cliente.getUbicacionCliente());
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
