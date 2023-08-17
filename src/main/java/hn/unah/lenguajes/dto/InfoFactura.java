package hn.unah.lenguajes.dto;

import hn.unah.lenguajes.models.ViajeOrdenServicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoFactura {
	public ViajeOrdenServicio viaje;
	public double monto;
	
}
