package hn.unah.lenguajes.services;

import java.util.List;

import hn.unah.lenguajes.dto.SolicitudViaje;
import hn.unah.lenguajes.models.OrdenServicio;

public interface OrdenServicioServices {
	public List<OrdenServicio> obtenerOrden_Servicioes();
	
	public OrdenServicio crearOrdenServicio(SolicitudViaje datos);
}
