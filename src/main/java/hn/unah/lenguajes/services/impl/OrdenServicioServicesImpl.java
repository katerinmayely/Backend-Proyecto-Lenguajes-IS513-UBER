package hn.unah.lenguajes.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.dto.DistanciaAutomovilVelocidad;
import hn.unah.lenguajes.dto.InfoServicio;
import hn.unah.lenguajes.dto.SolicitudViaje;
import hn.unah.lenguajes.models.Automovil;
import hn.unah.lenguajes.models.Cliente;
import hn.unah.lenguajes.models.OrdenServicio;
import hn.unah.lenguajes.models.Ubicacion;
import hn.unah.lenguajes.models.ViajeOrdenServicio;
import hn.unah.lenguajes.repositories.AutomovilesRepository;
import hn.unah.lenguajes.repositories.ClientesRepository;
import hn.unah.lenguajes.repositories.OrdenServicioRepository;
import hn.unah.lenguajes.repositories.ViajeOrdenServicioRepository;
import hn.unah.lenguajes.services.OrdenServicioServices;
@Service
public class OrdenServicioServicesImpl implements OrdenServicioServices{
	
	@Autowired
	private OrdenServicioRepository repo;
	
	@Autowired
	private ClientesRepository repoC;
	
	@Autowired
	private AutomovilesRepository repoA;
	
	@Autowired
	private ViajeOrdenServicioRepository repoV;
	

	
	@Override
	public List<OrdenServicio> obtenerOrden_Servicioes() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public InfoServicio crearOrdenServicio(SolicitudViaje ordenServicio) {
		
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
		DistanciaAutomovilVelocidad info=encontrarAutoCercano(partida);
		
		
		ViajeOrdenServicio nvoViaje=new ViajeOrdenServicio(0, new Date(), nvaOrden, null, info.getAutomovil().getConductor() );
		repoV.save(nvoViaje);
			
	    double tiempo=info.getDistanciaMinima()/info.getVelocidad();
	    
	     
		
		final double tarifaPorMinuto=2;
		final double tarifaPorKm=10;
		
		double monto=tarifaPorMinuto*tiempo+info.getDistanciaMinima()*tarifaPorKm;
		
		
	    InfoServicio infoServicio=new InfoServicio(info.getAutomovil().getConductor().getNombre(), tiempo, monto);
	    return infoServicio;
			
		
		
	
	}

	
	public DistanciaAutomovilVelocidad encontrarAutoCercano(Ubicacion ubicacionInicial) {
		final double vAutomovil=30;
		
		double distanciaMinima;
		
		List<Automovil> listaAutos=(List<Automovil>) repoA.findAll();
		double distancia=0.0;
		
		Automovil autoMasCercano=listaAutos.get(0);	
		distanciaMinima=distanciaCoord(listaAutos.get(0).getUbicacion().getLatitud(), listaAutos.get(0).getUbicacion().getLongitud(), ubicacionInicial.getLatitud(), ubicacionInicial.getLongitud());
		
		
		for (int i=0;i<listaAutos.size();i++) {
		
			
		distancia=distanciaCoord(listaAutos.get(i).getUbicacion().getLatitud(), listaAutos.get(i).getUbicacion().getLongitud(), ubicacionInicial.getLatitud(), ubicacionInicial.getLongitud());
			if (distancia<distanciaMinima) {
				distanciaMinima=distancia;
				autoMasCercano=listaAutos.get(i);
			}
		}
	
		DistanciaAutomovilVelocidad info=new DistanciaAutomovilVelocidad(distanciaMinima, autoMasCercano, vAutomovil );
	
		return info;
	}
	
	public  double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
	    double radioTierra = 6371; // en kilómetros
	    double dLat = Math.toRadians(lat2 - lat1);
	    double dLng = Math.toRadians(lng2 - lng1);
	    double sindLat = Math.sin(dLat / 2);
	    double sindLng = Math.sin(dLng / 2);
	    double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
	            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
	    double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
	    double distancia = radioTierra * va2;

	    return distancia;//distancia en metros
	}

	
	

}

