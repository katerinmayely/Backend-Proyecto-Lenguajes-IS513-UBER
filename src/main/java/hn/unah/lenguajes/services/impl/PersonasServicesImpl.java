package hn.unah.lenguajes.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.dto.ClientePersona;
import hn.unah.lenguajes.dto.ConductorPersona;
import hn.unah.lenguajes.models.Cliente;
import hn.unah.lenguajes.models.Conductor;
import hn.unah.lenguajes.models.Persona;
import hn.unah.lenguajes.repositories.PersonasRepository;
import hn.unah.lenguajes.services.PersonaServices;

@Service
public class PersonasServicesImpl implements PersonaServices{
	
	@Autowired
	private PersonasRepository repo;

	@Override
	public List<Persona> obtenerPersonaes() {
		return (List<Persona>) repo.findAll();
	}

	@Override
	public Persona buscarPersonaPorId(String id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Persona crearPersona(Persona persona) {
		repo.save(persona);
		return persona;
	}

	@Override
	public Persona eliminarPersona(String id) {
		repo.deleteById(id);
		return null;
	}

	@Override
	public Persona actualizarPersona(String id, Persona persona) {
		Persona nvaPersona=repo.findById(id).get();
		nvaPersona.setNombre(persona.getNombre());
		nvaPersona.setP_apellido(persona.getP_apellido());
		nvaPersona.setFecha_nacimiento(persona.getFecha_nacimiento());
		nvaPersona.setGenero(persona.getGenero());
		nvaPersona.setCorreo(persona.getCorreo());
		repo.deleteById(id);
		repo.save(nvaPersona);
		return persona;
	}

	@Override
	public Persona hacerConductor(ConductorPersona conductorPersona) {
	
		if (repo.existsById(conductorPersona.getDni())) {
			Persona persona=repo.findById(conductorPersona.getDni()).get();
			Conductor nvoConductor=new Conductor();
			nvoConductor.setFecha_ingreso(conductorPersona.getFechaIngreso());
			nvoConductor.setCargos(conductorPersona.getCargo());
			nvoConductor.setSalario(conductorPersona.getSalario());
			persona.setConductores(nvoConductor);
			repo.save(persona);
			
			return persona;}
		
			return null;
		}

	@Override
	public Persona hacerCliente(ClientePersona clientePersona) {
		
		if (repo.existsById(clientePersona.getDni()) && repo.existsById(clientePersona.getDni())) {
	
			Persona persona=repo.findById(clientePersona.getDni()).get();
			Cliente nvoCliente=new Cliente();
			nvoCliente.setCoordenadascliente(clientePersona.getCoordenada());
			nvoCliente.setTarjetaVinculada(clientePersona.getTarjeta());
			persona.setCliente(nvoCliente);
			repo.save(persona);
			return persona;
		}
			
		return null;
	}

}
