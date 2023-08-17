package hn.unah.lenguajes.services.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.dto.ViajeServicio;
import hn.unah.lenguajes.models.Automovil;
import hn.unah.lenguajes.models.OrdenServicio;
import hn.unah.lenguajes.models.ViajeOrdenServicio;
import hn.unah.lenguajes.repositories.AutomovilesRepository;
import hn.unah.lenguajes.repositories.OrdenServicioRepository;
import hn.unah.lenguajes.repositories.ViajeOrdenServicioRepository;
import hn.unah.lenguajes.services.ViajeOrdenServicioServices;

@Service
public class ViajeOrdenServicioImpl implements ViajeOrdenServicioServices{
	@Autowired
	private ViajeOrdenServicioRepository repo;
	
	@Autowired
	private AutomovilesRepository autoA;
	
	@Autowired
	private OrdenServicioRepository repoO;
	
	@Autowired
	private ViajeOrdenServicioRepository repoV;
	
	@Override
	public List<ViajeOrdenServicio> obtenerViajeOrdenServicio() {
		return (List<ViajeOrdenServicio>) repo.findAll();
	}

	@Override
	public ViajeOrdenServicio buscarViajeOrdenServicioPorId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public ViajeOrdenServicio crearViajeOrdenServicio(ViajeServicio viaje) {
		
		ViajeOrdenServicio nvoViaje=new ViajeOrdenServicio();
		int idordenservicio=viaje.getIdordenservicio();
		String placa=viaje.getPlaca();
		nvoViaje.setConductor(autoA.findById(placa).get().getConductor());
		nvoViaje.setFecha_y_hora_viaje(new Date());
		nvoViaje.setOrden_servicio(repoO.findById(idordenservicio).get());
		repoV.save(nvoViaje);
		return nvoViaje;
		

	
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

	@Override
	public ViajeOrdenServicio crearViajeOrdenServicio(ViajeOrdenServicio Viaje_Orden_Servicio) {
		// TODO Auto-generated method stub
		return null;
	}

}
