package hn.unah.lenguajes.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.models.Direccion;
import hn.unah.lenguajes.repositories.DireccionesRepository;
import hn.unah.lenguajes.services.DireccionServices;

@Service
public class DireccionesServicesImpl implements DireccionServices{
	@Autowired
	private DireccionesRepository repo;
	
	@Override
	public List<Direccion> obtenerDirecciones() {
		return (List<Direccion>) repo.findAll();
		
	}

	@Override
	public Direccion buscarDireccionesPorId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Direccion crearDirecciones(Direccion direccion) {
		// TODO Auto-generated method stub
		repo.save(direccion);
		return direccion;
	}

	@Override
	public Direccion eliminarDirecciones(int id) {
		repo.deleteById(id);
		return null;
	}

	@Override
	public Direccion actualizarDirecciones(int id, Direccion direccion) {
		Direccion nvaDireccion=repo.findById(id).get();
		nvaDireccion.setDescripcion(direccion.getDescripcion());
		nvaDireccion.setMunicipio(direccion.getMunicipio());
		nvaDireccion.setColonia(direccion.getColonia());
		nvaDireccion.setDepartamento(direccion.getDepartamento());
		nvaDireccion.setPais(direccion.getPais());
		
		repo.deleteById(id);
		repo.save(nvaDireccion);
		return direccion;
	}
}
