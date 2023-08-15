package hn.unah.lenguajes.services;

import java.util.List;
import hn.unah.lenguajes.models.Direccion;

public interface DireccionServices {
	public List<Direccion> obtenerDirecciones();
	public Direccion buscarDireccionesPorId(int id);
	public Direccion crearDirecciones(Direccion direccion);
	public Direccion eliminarDirecciones(int id);
	public Direccion actualizarDirecciones(int id, Direccion direccion);
}
