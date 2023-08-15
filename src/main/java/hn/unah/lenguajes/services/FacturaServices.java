package hn.unah.lenguajes.services;

import java.util.List;
import hn.unah.lenguajes.models.Factura;

public interface FacturaServices {
	public List<Factura> obtenerFacturaes();
	public Factura buscarFacturaPorId(int id);
	public Factura crearFactura(Factura factura);
	public Factura eliminarFactura(int id);
	public Factura actualizarFactura(int id, Factura factura);
}
