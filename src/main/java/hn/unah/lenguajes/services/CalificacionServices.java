package hn.unah.lenguajes.services;

import java.util.List;
import hn.unah.lenguajes.models.Calificacion;

public interface CalificacionServices {

	public List <Calificacion> obtenerCalificaciones();
	public Calificacion obtenerCalificacionPorId(int id);
	public Calificacion eliminarCalificacion(int id);
	public Calificacion crearCalificacion(Calificacion calificacion);
	public Calificacion actualizarCalificacion(int id, Calificacion calificacion);
	
}
