package hn.unah.lenguajes.services;

import java.util.List;
import hn.unah.lenguajes.models.Conductor;

public interface ConductorServices {
	public List<Conductor> obtenerConductoreses();
	public Conductor buscarConductoresPorId(int id);
	public Conductor crearConductores(Conductor conductor);
	public Conductor eliminarConductores(int id);
	public Conductor actualizarConductores(int id, Conductor conductor);
}
