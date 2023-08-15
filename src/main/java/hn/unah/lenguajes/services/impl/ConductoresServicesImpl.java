package hn.unah.lenguajes.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.models.Conductor;
import hn.unah.lenguajes.repositories.ConductoresRepository;
import hn.unah.lenguajes.services.ConductorServices;

@Service
public class ConductoresServicesImpl implements ConductorServices{
	
	@Autowired
	private ConductoresRepository repo;
	
	@Override
	public List<Conductor> obtenerConductoreses() {
		return (List<Conductor>) repo.findAll();
		
	}

	@Override
	public Conductor buscarConductoresPorId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Conductor crearConductores(Conductor conductor) {
		repo.save(conductor);
		return conductor;
	}

	@Override
	public Conductor eliminarConductores(int id) {
		repo.deleteById(id);
		return null;
	}

	@Override
	public Conductor actualizarConductores(int id, Conductor conductor) {
		Conductor nvoConductor=repo.findById(id).get();
	
		nvoConductor.setFecha_ingreso(conductor.getFecha_ingreso());
		nvoConductor.setCargos(conductor.getCargos());
		nvoConductor.setSalario(conductor.getSalario());
		nvoConductor.setCalificacion(conductor.getCalificacion());
		repo.deleteById(id);
		repo.save(nvoConductor);
		return conductor;}
		
}
