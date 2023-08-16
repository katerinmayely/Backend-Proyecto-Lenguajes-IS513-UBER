package hn.unah.lenguajes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.dto.AutoConductor;
import hn.unah.lenguajes.dto.NuevoAutomovil;
import hn.unah.lenguajes.models.Automovil;
import hn.unah.lenguajes.models.Conductor;
import hn.unah.lenguajes.repositories.AutomovilesRepository;
import hn.unah.lenguajes.repositories.ConductoresRepository;
import hn.unah.lenguajes.services.AutomovilServices;

@Service
public class AutomovilServicesImpl implements AutomovilServices{
	
	@Autowired
	private AutomovilesRepository repo;
	
	@Autowired 
	private ConductoresRepository repoC;
	

	@Override
	public List<Automovil> obtenerAutomoviles() {
		return (List<Automovil>) repo.findAll();
		
	}

	@Override
	public Automovil buscarAutomovilPorId(String id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public boolean agregarAutomovil(NuevoAutomovil datos) {
		
		if(datos.getAniosAntiguedad() >= 10 && datos.getCuatroPuertas() == 1 && datos.getAire() == 1 
				&& datos.getDobleAirbag() == 1 && datos.getPermiso() == 1 && datos.getMatricula() != null) {
			
			Automovil nvoAutomovil = new Automovil(datos.getMatricula(), datos.getModelo(), datos.getMarca(), 
					datos.getColor(), datos.getTipoCombustible(), null, true, null);
		
			repo.save(nvoAutomovil);
			return true;
		}
		
		return false;
	}

	@Override
	public Automovil eliminarAutomovil(String id) {
		repo.deleteById(id);
		return null;
	}

	@Override
	public Automovil actualizarAutomovil(String id, Automovil automovil) {
		Automovil automovilViejo=repo.findById(id).get();
		automovilViejo.setColor(automovil.getColor());
		automovilViejo.setConductores(automovil.getConductores());
		automovilViejo.setModelo(automovil.getModelo());
		automovilViejo.setMarca(automovil.getMarca());
		automovilViejo.setTipocombustible(automovil.getTipocombustible());
		automovilViejo.setCoordenadasauto(automovil.getCoordenadasauto());
		automovilViejo.setDisponibilidad(automovil.isDisponibilidad());
		repo.deleteById(id);
		repo.save(automovilViejo);
		return automovil;
	}

	@Override
	public Automovil asignarConductorAutomovil(AutoConductor autoC){
		Conductor conductor=repoC.findById(autoC.getIdConductor()).get();
		Automovil auto=new Automovil();
		auto.setColor(autoC.getColor());
		auto.setConductores(conductor);
		auto.setCoordenadasauto(autoC.getCoordenadasAuto());
		auto.setMarca(autoC.getMarca());
		auto.setTipocombustible(autoC.getTipoCombustible());
		auto.setModelo(autoC.getModelo());
		auto.setDisponibilidad(autoC.getDisponibilidad());
		auto.setPlaca(autoC.getPlaca());
		repo.save(auto);
		return auto;
	}
	
}
