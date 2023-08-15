package hn.unah.lenguajes.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.models.ViajeOrdenServicio;
import hn.unah.lenguajes.repositories.ViajeOrdenServicioRepository;
import hn.unah.lenguajes.services.ViajeOrdenServicioServices;

@Service
public class ViajeOrdenServicioImpl implements ViajeOrdenServicioServices{
	@Autowired
	private ViajeOrdenServicioRepository repo;
	
	@Override
	public List<ViajeOrdenServicio> obtenerViajeOrdenServicio() {
		return (List<ViajeOrdenServicio>) repo.findAll();
	}

	@Override
	public ViajeOrdenServicio buscarViajeOrdenServicioPorId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public ViajeOrdenServicio crearViajeOrdenServicio(ViajeOrdenServicio viaje) {
		repo.save(viaje);
		return viaje;
	}

	@Override
	public ViajeOrdenServicio eliminarViaje_Orden_Servicio(int id) {
		repo.deleteById(id);
		return null;
	}

	@Override
	public ViajeOrdenServicio actualizarViaje_Orden_Servicio(int id, ViajeOrdenServicio viaje) {
		ViajeOrdenServicio nvaViaje_Orden_Servicio=repo.findById(id).get();
		nvaViaje_Orden_Servicio.setFecha_y_hora_viaje(viaje.getFecha_y_hora_viaje());
		repo.deleteById(id);
		repo.save(nvaViaje_Orden_Servicio);
		return viaje;
	}

}
