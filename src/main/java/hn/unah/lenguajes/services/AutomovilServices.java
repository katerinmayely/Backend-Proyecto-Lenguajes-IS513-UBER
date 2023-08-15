package hn.unah.lenguajes.services;

import java.util.List;
import hn.unah.lenguajes.models.Automovil;
import hn.unah.lenguajes.dto.AutoConductor;

public interface AutomovilServices {
	
	public List<Automovil> obtenerAutomoviles();
	public Automovil buscarAutomovilPorId(String id);
	public Automovil crearAutomovil(Automovil automovil);
	public Automovil eliminarAutomovil(String id);
	public Automovil actualizarAutomovil(String id, Automovil automovil);
	public Automovil asignarConductorAutomovil(AutoConductor AutoConductor);
	
	

}
