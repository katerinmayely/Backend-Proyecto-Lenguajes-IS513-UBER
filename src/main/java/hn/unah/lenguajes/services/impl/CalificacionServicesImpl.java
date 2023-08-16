package hn.unah.lenguajes.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.models.Calificacion;
import hn.unah.lenguajes.repositories.CalificacionesRepository;
import hn.unah.lenguajes.services.CalificacionServices;

@Service
public class CalificacionServicesImpl implements CalificacionServices{
	@Autowired
	private CalificacionesRepository repo;
	
	@Override
	public List<Calificacion> obtenerCalificaciones() {
		return (List<Calificacion>) repo.findAll();
		
	}

	@Override
	public Calificacion obtenerCalificacionPorId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Calificacion crearCalificacion(Calificacion Calificacion) {
		repo.save(Calificacion);
		return Calificacion;
	}

	@Override
	public Calificacion eliminarCalificacion(int id) {
		repo.deleteById(id);
		return null;
	}

	@Override
	public Calificacion actualizarCalificacion(int id, Calificacion calificacion) {
		Calificacion nvaCalificacion=repo.findById(id).get();
		nvaCalificacion.setCalificacionDeServicio(calificacion.getCalificacionDeServicio());
		nvaCalificacion.setComentario(calificacion.getComentario());
		nvaCalificacion.setCliente(calificacion.getCliente());
		nvaCalificacion.setConductor(calificacion.getConductor());
		
		repo.deleteById(id);
		repo.save(nvaCalificacion);
		return calificacion;
	}

}
