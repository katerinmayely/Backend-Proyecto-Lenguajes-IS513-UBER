package hn.unah.lenguajes.services;

import java.util.List;
import hn.unah.lenguajes.models.Automovil;
import hn.unah.lenguajes.dto.AutoConductor;
import hn.unah.lenguajes.dto.NuevoAutomovil;

public interface AutomovilServices {
	
	public List<Automovil> obtenerAutomoviles();
	public Automovil buscarAutomovilPorId(String id);
	public boolean agregarAutomovil(NuevoAutomovil datos);
	public Automovil eliminarAutomovil(String id);
	public Automovil actualizarAutomovil(String id, Automovil automovil);
	public Automovil asignarConductorAutomovil(AutoConductor AutoConductor);
	
	

}
