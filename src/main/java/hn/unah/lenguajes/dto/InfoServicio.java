package hn.unah.lenguajes.dto;

import hn.unah.lenguajes.models.ViajeOrdenServicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class InfoServicio {
	private String nombreConductor;
	private double tiempoDeLLegada;
	private double monto;
	private ViajeOrdenServicio viaje;
	
}
