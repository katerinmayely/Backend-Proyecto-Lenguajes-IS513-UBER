package hn.unah.lenguajes.services.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.dto.InfoFactura;
import hn.unah.lenguajes.models.Factura;
import hn.unah.lenguajes.models.ViajeOrdenServicio;
import hn.unah.lenguajes.repositories.FacturasRepository;
import hn.unah.lenguajes.repositories.ViajeOrdenServicioRepository;
import hn.unah.lenguajes.services.FacturaServices;

@Service
public class FacturaServicesImpl implements FacturaServices{
	
	@Autowired 
	private FacturasRepository repo;
	
	@Autowired
	private ViajeOrdenServicioRepository repoV;

	@Override
	public List<Factura> obtenerFacturaes() {
		return (List<Factura>) repo.findAll();
		
	}

	@Override
	public Factura buscarFacturaPorId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Factura crearFactura(InfoFactura infoFactura) {
		Date fecha=new Date();
		
		double subtotal=infoFactura.getMonto();
		double impuesto=0.15*subtotal;//0.15
		double descuento=0.05*subtotal;//0.05
		double totalAPagar=subtotal+impuesto-descuento;
	    ViajeOrdenServicio viaje=infoFactura.getViaje();
		Factura factura=new Factura(0, fecha, subtotal, impuesto, descuento, totalAPagar, viaje);
		repo.save(factura);
		viaje.setFactura(factura);
		repoV.save(viaje);
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

	@Override
	public Factura crearFactura(Factura factura) {
		// TODO Auto-generated method stub
		return null;
	}
}
