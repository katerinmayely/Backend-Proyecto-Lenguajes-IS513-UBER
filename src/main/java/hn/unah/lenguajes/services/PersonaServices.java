package hn.unah.lenguajes.services;

import java.util.List;
import hn.unah.lenguajes.models.Persona;
import hn.unah.lenguajes.dto.ClientePersona;
import hn.unah.lenguajes.dto.ConductorPersona;

public interface PersonaServices {
	public List<Persona> obtenerPersonaes();
	public Persona buscarPersonaPorId(String id);
	public Persona crearPersona(Persona persona);
	public Persona eliminarPersona(String id);
	public Persona actualizarPersona(String id, Persona persona);
	public Persona hacerConductor(ConductorPersona conductorPersona);
	public Persona hacerCliente(ClientePersona clientePersona);
}

