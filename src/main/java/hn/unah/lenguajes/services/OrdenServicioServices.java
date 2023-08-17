package hn.unah.lenguajes.services;

import java.util.List;

import hn.unah.lenguajes.dto.SolicitudViaje;
import hn.unah.lenguajes.models.OrdenServicio;

public interface OrdenServicioServices {
	public List<OrdenServicio> obtenerOrden_Servicioes();
	public OrdenServicio buscarOrdenServicioPorId(int id);
	public OrdenServicio eliminarOrden_Servicio(int id);
	public OrdenServicio actualizarOrden_Servicio(int id, OrdenServicio ordenServicio);
	

	public boolean crearOrdenServicio(SolicitudViaje datos);
}
