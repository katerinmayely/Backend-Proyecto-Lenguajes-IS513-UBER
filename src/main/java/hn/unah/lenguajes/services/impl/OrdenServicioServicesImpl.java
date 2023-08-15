package hn.unah.lenguajes.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.models.OrdenServicio;
import hn.unah.lenguajes.repositories.OrdenServicioRepository;
import hn.unah.lenguajes.services.OrdenServicioServices;

@Service
public class OrdenServicioServicesImpl implements OrdenServicioServices{
	
	@Autowired
	private OrdenServicioRepository repo;
	
	@Override
	public List<OrdenServicio> obtenerOrden_Servicioes() {
		return (List<OrdenServicio>) repo.findAll();	
	}

	@Override
	public OrdenServicio buscarOrdenServicioPorId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public OrdenServicio crearOrden_Servicio(OrdenServicio os) {
		repo.save(os);
		return os;
	}

	@Override
	public OrdenServicio eliminarOrden_Servicio(int id) {
		repo.deleteById(id);
		return null;
	}

	@Override
	public OrdenServicio actualizarOrden_Servicio(int id, OrdenServicio os) {
		OrdenServicio nvaOrden_Servicio=repo.findById(id).get();
		nvaOrden_Servicio.setIdDireccionInicial(os.getIdDireccionInicial());
		nvaOrden_Servicio.setIdDireccionFinal(os.getIdDireccionFinal());
		nvaOrden_Servicio.setTipoPago(os.getTipoPago());
		nvaOrden_Servicio.setStatus_orden(os.getStatus_orden());
		nvaOrden_Servicio.setFecha_y_hora_orden(os.getFecha_y_hora_orden());
		repo.deleteById(id);
		repo.save(nvaOrden_Servicio);
		return os;
	}
}

