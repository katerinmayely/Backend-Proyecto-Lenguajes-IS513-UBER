package hn.unah.lenguajes.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes.models.Factura;
import hn.unah.lenguajes.repositories.FacturasRepository;
import hn.unah.lenguajes.services.FacturaServices;

@Service
public class FacturaServicesImpl implements FacturaServices{
	
	@Autowired 
	private FacturasRepository repo;

	@Override
	public List<Factura> obtenerFacturaes() {
		return (List<Factura>) repo.findAll();
		
	}

	@Override
	public Factura buscarFacturaPorId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Factura crearFactura(Factura factura) {
		repo.save(factura);
		return factura;
	}

	@Override
	public Factura eliminarFactura(int id) {
		repo.deleteById(id);
		return null;
	}

	@Override
	public Factura actualizarFactura(int id, Factura factura) {
		Factura nvaFactura=repo.findById(id).get();
		nvaFactura.setFechaDeEmision(factura.getFechaDeEmision());
		nvaFactura.setSubtotal(factura.getSubtotal());
		nvaFactura.setImpuesto(factura.getImpuesto());
		nvaFactura.setDescuento(factura.getDescuento());
		nvaFactura.setTotalPagar(factura.getTotalPagar());
		repo.deleteById(id);
		repo.save(nvaFactura);
		return factura;
	}
}
