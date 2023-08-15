package hn.unah.lenguajes.services;

import java.util.List;
import hn.unah.lenguajes.models.ViajeOrdenServicio;

public interface ViajeOrdenServicioServices {
	public List<ViajeOrdenServicio> obtenerViajeOrdenServicio();
	public ViajeOrdenServicio buscarViajeOrdenServicioPorId(int id);
	public ViajeOrdenServicio crearViajeOrdenServicio(ViajeOrdenServicio Viaje_Orden_Servicio);
	public ViajeOrdenServicio eliminarViaje_Orden_Servicio(int id);
	public ViajeOrdenServicio actualizarViaje_Orden_Servicio(int id, ViajeOrdenServicio viaje);
}
