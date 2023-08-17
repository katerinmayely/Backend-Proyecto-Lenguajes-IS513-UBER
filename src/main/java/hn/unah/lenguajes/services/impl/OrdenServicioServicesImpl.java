package hn.unah.lenguajes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hn.unah.lenguajes.dto.SolicitudViaje;
import hn.unah.lenguajes.models.OrdenServicio;
import hn.unah.lenguajes.models.Ubicacion;
import hn.unah.lenguajes.repositories.OrdenServicioRepository;
import hn.unah.lenguajes.services.OrdenServicioServices;

public class OrdenServicioServicesImpl implements OrdenServicioServices{
	
	@Autowired
	private OrdenServicioRepository repo;

	@Override
	public List<OrdenServicio> obtenerOrden_Servicioes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdenServicio buscarOrdenServicioPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean crearOrdenServicio(SolicitudViaje ordenServicio) {
		
		Ubicacion partida;
		Ubicacion destino;
		String correoCliente;
		String tipoPago;
		
		//INCONCLUSO
		
		OrdenServicio nvaOrden = new OrdenServicio();
		repo.save(nvaOrden);
		
		return false;
	}

	@Override
	public OrdenServicio eliminarOrden_Servicio(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdenServicio actualizarOrden_Servicio(int id, OrdenServicio ordenServicio) {
		// TODO Auto-generated method stub
		return null;
	}

}
