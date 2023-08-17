package hn.unah.lenguajes.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.dto.SolicitudViaje;
import hn.unah.lenguajes.models.Cliente;
import hn.unah.lenguajes.models.OrdenServicio;
import hn.unah.lenguajes.models.Ubicacion;
import hn.unah.lenguajes.repositories.ClientesRepository;
import hn.unah.lenguajes.repositories.OrdenServicioRepository;
import hn.unah.lenguajes.services.OrdenServicioServices;
@Service
public class OrdenServicioServicesImpl implements OrdenServicioServices{
	
	@Autowired
	private OrdenServicioRepository repo;
	
	@Autowired
	private ClientesRepository repoC;
	@Override
	public List<OrdenServicio> obtenerOrden_Servicioes() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OrdenServicio crearOrdenServicio(SolicitudViaje ordenServicio) {
		
		Ubicacion partida=ordenServicio.getPartida();
		Ubicacion destino=ordenServicio.getDestino();
		String correoCliente=ordenServicio.getCorreoCliente();
		String tipoPago=ordenServicio.getTipoPago();
		
		//INCONCLUSO
		
		OrdenServicio nvaOrden = new OrdenServicio();
		Cliente cliente=repoC.findById(ordenServicio.getCorreoCliente()).get();
		nvaOrden.setCliente(cliente);
		nvaOrden.setFecha_y_hora_orden(new Date());
		nvaOrden.setStatus_orden(0);
		nvaOrden.setTipoPago(tipoPago);
		nvaOrden.setUbicacionInicial(partida);
		nvaOrden.setUbicacionFinal(destino);

		repo.save(nvaOrden);
		
		return nvaOrden;
	}



}

